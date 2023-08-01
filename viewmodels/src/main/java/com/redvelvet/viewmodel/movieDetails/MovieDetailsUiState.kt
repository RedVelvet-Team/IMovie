package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.viewmodel.base.BaseUiState

data class MovieDetailsScreenUiState(
    val movieDetails: MovieDetailsUiState? = null,
    val movieTopCasts: List<TopCastUiState> = emptyList(),
    val movieKeywords: List<KeywordUiState> = emptyList(),
    val similarMovies: List<MovieUiState> = emptyList(),
    val movieImages: List<String> = emptyList(),
    val movieReviews: List<MovieReviewUiState> = emptyList(),
    val recommendedMovies: List<MovieUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
) : BaseUiState {

    data class MovieDetailsUiState(
        val movieImage: String,
        val movieName: String,
        val listOfGenres: List<String>,
        val movieTime: String,
        val languageOfMovie: String,
        val movieRate: String,
        val movieDescription: String,
        val movieStatus: String,
        val movieReleaseDate: String,
        val movieProductionCountries: String,
    )


    data class MovieUiState(
        val movieImage: String,
        val movieName: String,
    )

    data class TopCastUiState(
        val castImage: String,
        val castName: String,
    )

    data class KeywordUiState(
        val keywordName: String,
        val keywordId: Int,
    )

    data class MovieReviewUiState(
        val reviewAuthor: String,
        val reviewDescription: String,
        val reviewRate: String,
        val reviewDate: String,
    )

}

