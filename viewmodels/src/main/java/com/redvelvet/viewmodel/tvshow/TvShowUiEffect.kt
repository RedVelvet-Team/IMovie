package com.redvelvet.viewmodel.tvshow

sealed interface TvShowUiEffect{
    data object NavigateTvShowToCategoryScreen : TvShowUiEffect
    data class NavigateToTopCastSeeAllScreen(val id: String) : TvShowUiEffect
    data class NavigateToActorDetailsScreen(val id: String) : TvShowUiEffect
    data class NavigateToSeasonSeeAllScreen(val id: String) : TvShowUiEffect
    data class NavigateToSeasonDetailsScreen(val id: String, val seasonId: Int) : TvShowUiEffect
    data class NavigateToTvShowPosterSeeAllScreen(val id: String) : TvShowUiEffect
    data object NavigateToTvShowPosterScreen : TvShowUiEffect
    data class NavigateToReviewSeeAllScreen(val id: String) : TvShowUiEffect
    data object NavigateToTvShowReviewDetailsScreen : TvShowUiEffect
    data class NavigateToTvShowRecommendationSeeAllScreen(val id: String) : TvShowUiEffect
    data class NavigateToTvShowDetails(val id: String) : TvShowUiEffect
}