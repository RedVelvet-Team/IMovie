package com.redvelvet.viewmodel.details_ui_states

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class MediaDetailsScreenUiState(
    val data: AllMediaDetailsUiState? = null,
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val isFavorite: Boolean = false,
    val isSavedToList: Boolean = false,
    val isRated: Boolean = false,
    val favoriteActionState: FavoriteActionUiState = FavoriteActionUiState(),
    val addToWatchListActionUiState: AddToWatchListActionUiState = AddToWatchListActionUiState(),
    val rateActionUiState: RateActionUiState = RateActionUiState(),
) : BaseUiState {
    data class AllMediaDetailsUiState(
        val details: MediaDetailsUiState,
        val topCast: List<MediaTopCastUiState>,
        val keyWords: List<String>,
        val similar: List<MovieSimilarUiState>,
        val tvSeasons: List<TVSeriesSeasonsUiState>,
        val images: List<String>,
        val reviews: List<MediaReviewsUiState>,
        val recommendations: List<MediaRecommendationsUiState>
    )

    data class MediaDetailsUiState(
        val genres: List<String> = emptyList(),
        val id: Int = 0,
        val mediaTrailerUrl: String = "",
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
        val voteAverage: Double = 0.0,
    )

    data class MediaTopCastUiState(
        val castId: Int = 0,
        val castName: String = "",
        val castImage: String = ""
    )

    data class MovieSimilarUiState(
        val mediaId: Int = 0,
        val mediaName: String = "",
        val mediaImage: String = "",
    )

    data class MediaReviewsUiState(
        val reviewId: String = "",
        val reviewAuthor: String = "",
        val reviewDate: String = "",
        val reviewStars: Double = 0.0,
        val reviewDescription: String = "",
    )

    data class MediaRecommendationsUiState(
        val mediaId: Int = 0,
        val mediaName: String = "",
        val mediaImage: String = "",
    )

    data class TVSeriesSeasonsUiState(
        val seasonId: Int = 0,
        val airDate: String = "",
        val posterSeason: String = "",
        val voteSeasonAverage: Double = 0.0,
        val seasonNumber: String = "",
        val episodeNumber: Int = 0,
        val seasonDescription: String = "",
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

    data class RateActionUiState(
        var data: String? = null,
        val isLoading: Boolean = true,
        val error: ErrorUiState? = null
    )
}