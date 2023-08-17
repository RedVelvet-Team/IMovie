package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing


@Composable
fun MediaInfoCard(
    posterPath: String = "",
    originalTitle: String = "",
    genres: List<String> = emptyList(),
    hasTime: Boolean = false,
    hasDate: Boolean = false,
    movieTime: String = "",
    seriesDate: String = "",
    spokenLanguages: String = "",
    onClickGenre: (genre: String) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.spacing24)
    ) {
        ItemBasicCardForDetailsScreens(
            imagePainter = rememberAsyncImagePainter(model = posterPath),
            hasName = false,
            hasDateAndCountry = false,
            modifier = Modifier
                .width(MaterialTheme.dimens.dimens104)
                .height(MaterialTheme.dimens.dimens130),
            isMediaInfoCard = true
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing12)
        Column {
            Box(
                modifier = Modifier
                    .padding(
                        end = MaterialTheme.spacing.spacing16,
                        bottom = MaterialTheme.spacing.spacing16,
                    )
            ) {
                Text(
                    text = originalTitle,
                    style = Typography.titleLarge,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(
                        bottom = MaterialTheme.spacing.spacing12,
                    )
            ) {
                items(genres.size) { index ->
                    GenreButton(
                        genre = genres[index],
                        onGenreClick = { onClickGenre }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            )
            AnimatedVisibility(hasTime) {
                Box(
                    modifier = Modifier
                        .padding(
                            end = MaterialTheme.spacing.spacing16,
                            bottom = MaterialTheme.spacing.spacing8
                        )
                ) {
                    LabeledValueHorizontal(
                        movieTime = movieTime.ifEmpty { "NAN" },
                        icon = R.drawable.movie_time,
                        iconDescription = R.string.media_date,
                    )
                }
            }
            AnimatedVisibility(hasDate) {
                Box(
                    modifier = Modifier
                        .padding(
                            end = MaterialTheme.spacing.spacing16,
                            bottom = MaterialTheme.spacing.spacing16
                        )
                ) {
                    LabeledValueHorizontal(
                        movieTime = seriesDate.ifEmpty { "NAN" },
                        icon = R.drawable.icon_date,
                        iconDescription = R.string.media_time
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            ) {
                LabeledValueHorizontal(
                    movieTime = spokenLanguages,
                    icon = R.drawable.global,
                    iconDescription = R.string.media_language
                )
            }
        }

    }
}

