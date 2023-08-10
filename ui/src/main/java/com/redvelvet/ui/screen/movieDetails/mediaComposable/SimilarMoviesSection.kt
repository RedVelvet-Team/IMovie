package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun SimilarMoviesSection(
    it: List<MovieDetailsScreenUiState.MovieSimilarUiState>,
    interaction: MovieDetailsInteraction,
) {
    ItemsSection(
        label = "Similar Movies",
        images = it.map { it2 -> it2.mediaImage },
        movieIds = it.map { it2 -> it2.mediaId },
        hasName = true,
        name = it.map { it2 -> it2.mediaName },
        hasCustomList = false,
        hasDateAndCountry = false,
        onClickSeeAll = { interaction.onClickSimilarMoviesSeeAll() },

        )
}
