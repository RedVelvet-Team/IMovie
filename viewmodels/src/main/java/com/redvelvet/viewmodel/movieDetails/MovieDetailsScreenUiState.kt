package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class MovieDetailsScreenUiState(
    val data: MovieFullDetailsUiState? = null,
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val favoriteActionState: FavoriteActionUiState = FavoriteActionUiState(),
    val addToWatchListActionUiState: AddToWatchListActionUiState = AddToWatchListActionUiState(),

) : BaseUiState {
    data class MovieFullDetailsUiState(
        val details: MovieDetailsUiState,
        val topCast: List<MovieTopCastUiState>,
        val keyWords: List<String>,
        val similar: List<MovieSimilarUiState>,
        val images: List<MovieImagesUiState>,
        val reviews: List<MovieReviewsUiState>,
        val recommendations: List<MovieRecommendationsUiState>
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
        val spokenLanguages: String = "",
        val status: String = "",
        val tagline: String = "",
        val title: String = "",
        val video: Boolean = false,
        val voteAverage: Double = 0.0,
    )

    data class MovieTopCastUiState(
        val castId: Int = 0,
        val castName: String = "",
        val castImage: String = ""
    )

    data class MovieSimilarUiState(
        val mediaId: Int = 0,
        val mediaName: String = "",
        val mediaImage: String = "",
    )

    data class MovieImagesUiState(
        val mediaImage: String = ""
    )

    data class MovieReviewsUiState(
        val reviewId: String = "",
        val reviewAuthor: String = "",
        val reviewDate: String = "",
        val reviewStars: Double = 0.0,
        val reviewDescription: String = "",
    )

    data class MovieRecommendationsUiState(
        val mediaId: Int = 0,
        val mediaName: String = "",
        val mediaImage: String = "",
    )

    data class FavoriteActionUiState(
        var data: String? = null,
        val isLoading: Boolean = true,
        val error: ErrorUiState? = null
    )
    data class AddToWatchListActionUiState(
        var data: String? = null,
        val isLoading: Boolean = true,
        val error: ErrorUiState? = null
    )

}





