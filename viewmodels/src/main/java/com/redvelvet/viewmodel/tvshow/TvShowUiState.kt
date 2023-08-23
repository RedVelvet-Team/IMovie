package com.redvelvet.viewmodel.tvshow

import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.entities.tv.TvShowCast
import com.redvelvet.entities.tv.TvShowRecommendation
import com.redvelvet.entities.tv.TvShowReview
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.movieDetails.AddToWatchListActionUiState
import com.redvelvet.viewmodel.movieDetails.FavoriteActionUiState
import com.redvelvet.viewmodel.movieDetails.RateActionUiState
import com.redvelvet.viewmodel.utils.Constants

data class SeriesDetailsUiState(
    val tvShowId: Int = 0,
    val tvShowName: String = "",
    val tvShowImage: String = "",
    val tvShowLanguage: String = "",
    val tvShowTrailerUrl: String = "",
    val tvShowDescription: String = "",
    val genres: List<String> = emptyList(),
    val voteAverage: Double = 0.0,
    val firstAirDate: String = "",
    val topCast: List<TvShowTopCastUiState> = emptyList(),
    val keywords: List<String> = emptyList(),
    val seasons: List<SeasonUiState> = emptyList(),
    val reviews: List<TvShowReviewUiState> = emptyList(),
    val posters: List<String> = emptyList(),
    val recommendations: List<TvShowRecommendationUiState> = emptyList(),
    val myRating: Int = 0,
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val favoriteActionState: FavoriteActionUiState = FavoriteActionUiState(),
    val addToWatchListActionUiState: AddToWatchListActionUiState = AddToWatchListActionUiState(),
    val rateActionUiState: RateActionUiState = RateActionUiState(),
    ) : BaseUiState


data class SeasonUiState(
    val seasonId: Int = 0,
    val airDate: String = "",
    val posterSeason: String = "",
    val voteSeasonAverage: Double = 0.0,
    val seasonNumber: String = "",
    val episodeNumber: Int = 0,
    val seasonDescription: String = "",
)

data class TvShowReviewUiState(
    val id: String = "",
    val author: String = "",
    val rating: Double = 0.0,
    val createdAt: String = "",
    val content: String = "",
)

data class TvShowRecommendationUiState(
    val id: Int = 0,
    val poster: String = "",
    val seriesName: String = "",
)

data class TvShowTopCastUiState(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val knownFoDepartment: String = "",
)


fun TvShowCast.toTvShowTopCastUiState(): TvShowTopCastUiState {
    return TvShowTopCastUiState(
        id = id,
        name = name,
        image = Constants.BASE_IMAGE_URL + image,
        knownFoDepartment = knownFoDepartment,
    )
}

fun SeasonTvShow.toSeasonUiState(): SeasonUiState {
    return SeasonUiState(
        seasonId = seasonId,
        airDate = airDate,
        posterSeason = Constants.BASE_IMAGE_URL + posterSeason,
        voteSeasonAverage = voteSeasonAverage,
        seasonNumber = seasonNumber.toString(),
        episodeNumber = episodeCount,
        seasonDescription = seasonDescription,
    )
}

fun TvShowReview.toTvShowReviewUiState(): TvShowReviewUiState {
    return TvShowReviewUiState(
        author = author,
        rating = rating,
        createdAt = createdAt,
        content = content,
    )
}

fun TvShowRecommendation.toTvShowRecommendationUiState(): TvShowRecommendationUiState {
    return TvShowRecommendationUiState(
        poster = Constants.BASE_IMAGE_URL + poster,
        seriesName = seriesName,
    )
}
