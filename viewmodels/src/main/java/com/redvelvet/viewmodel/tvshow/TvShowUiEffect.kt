package com.redvelvet.viewmodel.tvshow

sealed interface TvShowUiEffect{
    data object NavigateTvShowToCategoryScreen : TvShowUiEffect
    data object NavigateTvShowToTopCastSeeAllScreen : TvShowUiEffect
    data object NavigateToTvShowTopCastDetailsScreen : TvShowUiEffect
    data object NavigateToSeasonSeeAllScreen : TvShowUiEffect
    data object NavigateToSeasonDetailsScreen : TvShowUiEffect
    data object NavigateToTvShowPosterSeeAllScreen : TvShowUiEffect
    data object NavigateToTvShowPosterScreen : TvShowUiEffect
    data object NavigateToTvShowReviewSeeAllScreen : TvShowUiEffect
    data object NavigateToTvShowReviewDetailsScreen : TvShowUiEffect
    data object NavigateToTvShowRecommendationSeeAllScreen : TvShowUiEffect
    data object NavigateToTvShowRecommendationDetailsScreen : TvShowUiEffect
}