package com.redvelvet.repository.localDto


data class TvShowRecommendationsLocalDto(
    val tvShowRecommendation: List<TvShowRecommendationLocalDto> = emptyList(),
)


data class TvShowRecommendationLocalDto(
    val poster: String = "",
    val seriesName: String = "",
)