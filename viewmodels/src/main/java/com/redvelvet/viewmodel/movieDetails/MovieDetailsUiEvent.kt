package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.viewmodel.login.LoginUiEvent

sealed interface MovieDetailsUiEvent {
    data object NavigateToGenreScreen : MovieDetailsUiEvent
    data object NavigateToTopCastSeeAllScreen : MovieDetailsUiEvent
    data object NavigateToTopCastDetailsScreen : MovieDetailsUiEvent
    data object NavigateToMoviesSeeAllScreen : MovieDetailsUiEvent
    data object NavigateToMovieDetailsScreen : MovieDetailsUiEvent
    data object NavigateToMovieImagesSeeAllScreen : MovieDetailsUiEvent
    data object NavigateToReviewSeeAllScreen : MovieDetailsUiEvent
    data object NavigateToReviewDetailsScreen : MovieDetailsUiEvent
}