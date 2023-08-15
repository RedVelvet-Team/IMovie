package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

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
import com.redvelvet.viewmodel.tvshow.SeriesDetailsUiState
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsInfoSection(
    it: SeriesDetailsUiState,
    interaction: TvShowDetailsInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.spacing16,
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        MediaInfoCard(
            data =
            MediaInfoCardData(
                posterPath = it.tvShowImage,
                originalTitle = it.tvShowName,
                genres = it.genres,
                hasTime = true,
                hasDate = false,
                seriesDate = it.firstAirDate,
                spokenLanguages = it.tvShowLanguage,
            ),
            interaction,
        )
        MediaRateRow(it.voteAverage.toString()) { interaction.onClickRateSeries(it.tvShowId, 5.5) }
        Box(
            modifier = Modifier
                .padding(end = MaterialTheme.spacing.spacing16)
        ) {
            LongExpandedText(it.tvShowDescription)
        }
    }
}
