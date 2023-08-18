package com.redvelvet.viewmodel.movieDetails


sealed class MovieDetailsUiEffect {
    data class NavigateToGenreScreen(val id: String) : MovieDetailsUiEffect()
    data object NavigateToTopCastSeeAllScreen : MovieDetailsUiEffect()
    data class NavigateToTopCastDetailsScreen(val id: String) : MovieDetailsUiEffect()
    data object NavigateToSimilarMoviesSeeAllScreen : MovieDetailsUiEffect()
    data object NavigateToRecommendedMoviesSeeAllScreen : MovieDetailsUiEffect()
    data class NavigateToMovieDetailsScreen(val id: String) : MovieDetailsUiEffect()
    data object NavigateToMovieImagesSeeAllScreen : MovieDetailsUiEffect()
    data object NavigateToReviewSeeAllScreen : MovieDetailsUiEffect()
    data class NavigateToReviewDetailsScreen(val id: String) : MovieDetailsUiEffect()
}