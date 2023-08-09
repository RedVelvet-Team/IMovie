package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun SimilarMoviesSection(
    it: List<MovieDetailsScreenUiState.MovieSimilarUiState>,
    uiEvent: MovieDetailsUiEvent
) {
    ItemsSection(
        label = "Similar Movies",
        images = it.map { it2 -> it2.mediaImage },
        hasName = true,
        name = it.map { it2 -> it2.mediaName },
        hasCustomList = false,
        hasDateAndCountry = false,
        onClickSeeAll = { uiEvent.onSimilarMovieSeeAll() },
        onClickItem = { uiEvent.onMovie(0) },
    )
}
