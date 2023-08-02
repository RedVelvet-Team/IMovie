package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.viewmodel.base.BaseUiState

data class MovieDetailsScreenUiState(
    val data: MovieFullDetailsUiState? = null,
    val isLoading: Boolean = true,
    val isError: Pair<Boolean, String> = Pair(false, "")
) : BaseUiState {
    data class MovieFullDetailsUiState(
        val details: MovieDetailsUiState,
        val images: MovieImagesUiState,
        val keyWords: MovieKeyWordsUiState,
        val recommendations: MovieRecommendationsUiState,
        val reviews: MovieReviewsUiState,
        val similar: MovieSimilarUiState,
        val topCast: MovieTopCastUiState
    )

    data class MovieDetailsUiState(
        val genres: List<String> = emptyList(),
        val homepage: String = "",
        val id: Int = 0,
        val originalTitle: String = "",
        val overview: String = "",
        val posterPath: String = "",
        val productionCountries: List<String> = emptyList(),
        val releaseDate: String = "",
        val revenue: Int = 0,
        val runtime: String = "",
        val spokenLanguages: List<String> = emptyList(),
        val status: String = "",
        val tagline: String = "",
        val title: String = "",
        val video: Boolean = false,
        val voteAverage: Double = 0.0,
    )

    data class MovieImagesUiState(
        val test: String = ""
    )

    data class MovieKeyWordsUiState(
        val test: String = ""
    )

    data class MovieRecommendationsUiState(
        val test: String = ""
    )

    data class MovieReviewsUiState(
        val test: String = ""
    )

    data class MovieSimilarUiState(
        val test: String = ""
    )

    data class MovieTopCastUiState(
        val test: String = ""
    )


}






