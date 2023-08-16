package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
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
            TopCastSection(it.topCast, interaction)
            MovieDetailsMoreInfoSection(it.details)
            KeyWordsSection(it.keyWords, interaction)
            SimilarMoviesSection(it.similar, interaction)
            MovieImagesSection(it.images, interaction)
            MovieReviewsSection(it.reviews, interaction)
            RecommendedMoviesSection(it.recommendations, interaction)
        }
    }
}

