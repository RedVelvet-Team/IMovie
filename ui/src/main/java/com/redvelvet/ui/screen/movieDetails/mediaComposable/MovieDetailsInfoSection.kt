package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.LongExpandedText
import com.redvelvet.ui.composable.MediaInfoCard
import com.redvelvet.ui.composable.MediaInfoCardData
import com.redvelvet.ui.composable.MediaRateRow
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MovieDetailsInfoSection(
    it: MovieDetailsScreenUiState.MovieDetailsUiState,
    interaction: MovieDetailsInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.spacing16,
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        MediaInfoCard(
            data = MediaInfoCardData(
                it.posterPath,
                it.originalTitle,
                it.genres,
                hasTime = true,
                hasDate = false,
                it.runtime,
                it.spokenLanguages,
            ),
            interaction,
        )
        MediaRateRow(it.voteAverage.toString()) { interaction.onClickRateMovie(it.id, 5.5) }
        Box(
            modifier = Modifier
                .padding(end = MaterialTheme.spacing.spacing16)
        ) {
            LongExpandedText(it.overview)
        }
    }
}
