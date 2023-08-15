package com.redvelvet.ui.composable

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
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction


@Composable
fun <T> MediaInfoCard(
    data: MediaInfoCardData,
    interaction: T,
) {
    Row(
        modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.spacing24)
    ) {
        ItemBasicCardForDetailsScreens(
            imagePainter = rememberAsyncImagePainter(model = data.posterPath),
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
                    text = data.originalTitle,
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
                items(data.genres.size) { index ->
                    GenreButton(
                        genre = data.genres[index],
                        onGenreClick = {
                            if (interaction is MovieDetailsInteraction) {
                                interaction.onClickGenre(data.genres[index])
                            }
                            if (interaction is TvShowDetailsInteraction) {
                                // TODO: ADD THIS INTERACTION
//                                interaction.onClickGenre(data.genres[index])
                            }

                        }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            )
            if (data.hasTime) {
                Box(
                    modifier = Modifier
                        .padding(
                            end = MaterialTheme.spacing.spacing16,
                            bottom = MaterialTheme.spacing.spacing8
                        )
                ) {
                    LabeledValueHorizontal(
                        movieTime = data.movieTime,
                        icon = R.drawable.movie_time,
                        iconDescription = R.string.media_date,
                    )
                }
            }
            if (data.hasDate) {
                Box(
                    modifier = Modifier
                        .padding(
                            end = MaterialTheme.spacing.spacing16,
                            bottom = MaterialTheme.spacing.spacing16
                        )
                ) {
                    LabeledValueHorizontal(
                        movieTime = data.seriesDate,
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
                    movieTime = data.spokenLanguages,
                    icon = R.drawable.global,
                    iconDescription = R.string.media_language
                )
            }
        }

    }
}

data class MediaInfoCardData(
    val posterPath: String = "",
    val originalTitle: String = "",
    val genres: List<String> = emptyList(),
    val hasTime: Boolean = false,
    val hasDate: Boolean = false,
    val movieTime: String = "",
    val spokenLanguages: String = "",
    val seriesDate: String = "",
)