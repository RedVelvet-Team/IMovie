package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun MediaInfoCard(
    data: MediaInfoCardData,
) {
    Row {
        ItemBasicCard(
            image = data.posterPath,
            hasName = false,
            hasDateAndCountry = false,
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing12)
        Column {
            Text(
                text = data.originalTitle,
                style = Typography.titleLarge,
                color = Color.White
            )
            SpacerVertical(height = MaterialTheme.spacing.spacing16)
            LazyRow {
                items(data.genres.size) {
                    GenreButton(genre = data.genres[it])
                }
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing12)
            if (data.hasTime) {
                LabeledValueHorizontal(
                    movieTime = data.movieTime,
                    icon = R.drawable.movie_time,
                    iconDescription = R.string.media_date
                )
                SpacerVertical(height = MaterialTheme.spacing.spacing8)
            }
            if (data.hasDate) {
                LabeledValueHorizontal(
                    movieTime = data.seriesDate,
                    icon = R.drawable.icon_date,
                    iconDescription = R.string.media_time
                )
                SpacerVertical(height = MaterialTheme.spacing.spacing8)
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing8)
            LabeledValueHorizontal(
                movieTime = data.spokenLanguages,
                icon = R.drawable.global,
                iconDescription = R.string.media_language
            )
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