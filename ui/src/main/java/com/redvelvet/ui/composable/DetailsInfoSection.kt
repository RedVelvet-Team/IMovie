package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing

@Composable
fun DetailsInfoSection(
    id: Int = 0,
    image: String = "",
    name: String = "",
    genres: List<String> = emptyList(),
    hasTime: Boolean = false,
    hasDate: Boolean = false,
    seriesDate: String = "",
    spokenLanguages: String = "",
    onClickGenre: (genre: String) -> Unit = {},
    onClickRate: (id: Int, rate: Double) -> Unit,
    voteAverage: Double = 0.0,
    description: String = "",
    isRated: Boolean,
) {
    var showDialog by remember { mutableStateOf(false) }
    var currentRating by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.spacing16,
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        MediaInfoCard(
            posterPath = image,
            originalTitle = name,
            genres = genres,
            hasTime = hasTime,
            hasDate = hasDate,
            seriesDate = seriesDate,
            spokenLanguages = spokenLanguages,
            onClickGenre = onClickGenre,
        )
        MediaRateRow(
            isRated, voteAverage.toString()
        ) {
            onClickRate(
                id, currentRating.toDouble()
            )
            if (!isRated) {
                showDialog = true
            }
        }
        if (showDialog) {
            RatingDialog(
                movieName = name,
                showDialogState = showDialog,
                ratingState = currentRating,
                modifier = Modifier
                    .background(MaterialTheme.color.backgroundPrimary),
                onSubmitClick = {
                    if (!isRated) {
                        onClickRate(id, currentRating.toDouble())
                        showDialog = false
                        currentRating = 0f
                    }
                },
                onClickCancel = {
                    showDialog = false
                    currentRating = 0f
                },
                onRatingChanged = { currentRating = it }
            )
        }
        if (description.isNotEmpty())
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            ) {
                LongExpandedText(description)
            }
    }
}
