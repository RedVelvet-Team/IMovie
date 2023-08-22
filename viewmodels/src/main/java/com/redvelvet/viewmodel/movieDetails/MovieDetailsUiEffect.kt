package com.redvelvet.viewmodel.movieDetails


sealed class MovieDetailsUiEffect {
    data class NavigateToGenreScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToTopCastSeeAllScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToTopCastDetailsScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToSimilarMoviesSeeAllScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToRecommendedMoviesSeeAllScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToMovieDetailsScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToMovieImagesSeeAllScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToReviewSeeAllScreen(val id: String) : MovieDetailsUiEffect()
    data class NavigateToReviewDetailsScreen(val id: String) : MovieDetailsUiEffect()
}