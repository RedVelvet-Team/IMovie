package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.viewmodel.tvshow.SeriesDetailsUiState
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsForegroundContent(
    state: SeriesDetailsUiState,
    interaction: TvShowDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    MediaDetailsForegroundContent(
        onScroll = onScroll
    ) {
        TvShowDetailsInfoSection(state, interaction)
        TvShowTopCastSection(state.topCast, interaction)
        KeyWordsSection(state.keywords)
        // TODO: ADD SEASIONS LIST
        // TvShowSeasonsSection(state.seasons, interaction)
        TvShowImagesSection(state.posters, interaction)
        TvShowReviewsSection(state.reviews, interaction)
        RecommendedTvshowSection(state.recommendations, interaction)
    }
}
