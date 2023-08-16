package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.TopCastSection
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MovieDetailsForegroundContent(
    state: MovieDetailsScreenUiState,
    interaction: MovieDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    MediaDetailsForegroundContent(
        onScroll = onScroll
    ) {
        state.data?.let {
            MovieDetailsInfoSection(it.details, interaction)
            it.topCast.let { topcasts ->
                TopCastSection(
                    topcasts.isNotEmpty(),
                    interaction::onClickTopCastSeeAll,
                    interaction::onClickCast,
                    topcasts.map { it2 -> it2.castImage },
                    topcasts.map { it2 -> it2.castName })
            }
            MovieDetailsMoreInfoSection(it.details)
            KeyWordsSection(it.keyWords)
            SimilarMoviesSection(it.similar, interaction)
            MovieImagesSection(it.images, interaction)
            MovieReviewsSection(it.reviews, interaction)
            RecommendedMoviesSection(it.recommendations, interaction)
        }
    }
}

