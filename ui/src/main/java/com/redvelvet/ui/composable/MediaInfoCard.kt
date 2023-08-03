package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun MediaInfoCard(
    data: MediaInfoCardData,
    onGenreClick: (String) -> Unit,
) {
    Row {
        ItemBasicCard(
            image = data.posterPath,
            hasName = false,
            hasDateAndCountry = false,
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing12)
        Column {
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            ) {
                Text(
                    text = data.originalTitle,
                    style = Typography.titleLarge,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing16)
            LazyRow {
                items(data.genres.size) {
                    GenreButton(genre = data.genres[it], onGenreClick = onGenreClick)
                }
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing12)
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            ) {}
            if (data.hasTime) {
                Box(
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.spacing16)
                ) {
                    LabeledValueHorizontal(
                        movieTime = data.movieTime,
                        icon = R.drawable.movie_time,
                        iconDescription = R.string.media_date,
                    )
                }
                SpacerVertical(height = MaterialTheme.spacing.spacing8)
            }
            if (data.hasDate) {
                Box(
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.spacing16)
                ) {
                    LabeledValueHorizontal(
                        movieTime = data.seriesDate,
                        icon = R.drawable.icon_date,
                        iconDescription = R.string.media_time
                    )
                }
                SpacerVertical(height = MaterialTheme.spacing.spacing8)
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing8)
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
    val posterPath: String,
    val originalTitle: String,
    val genres: List<String>,
    val hasTime: Boolean = false,
    val hasDate: Boolean = false,
    val movieTime: String,
    val spokenLanguages: String,
    val seriesDate: String = "",
)