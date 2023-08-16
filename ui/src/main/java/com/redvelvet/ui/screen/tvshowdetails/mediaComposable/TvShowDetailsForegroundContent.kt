package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.TopCastSection
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
        state.topCast.let { topcasts ->
            TopCastSection(
                topcasts.isNotEmpty(),
                interaction::onClickTopCastSeeAll,
                interaction::onClickCast,
                topcasts.map { it2 -> it2.image },
                topcasts.map { it2 -> it2.name })
        }
        KeyWordsSection(state.keywords)
        // TODO: ADD SEASIONS LIST
        // TvShowSeasonsSection(state.seasons, interaction)
        TvShowImagesSection(state.posters, interaction)
        TvShowReviewsSection(state.reviews, interaction)
        RecommendedTvshowSection(state.recommendations, interaction)
    }
}
