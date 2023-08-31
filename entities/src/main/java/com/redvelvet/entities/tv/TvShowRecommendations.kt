package com.redvelvet.entities.tv

data class TvShowRecommendations(
    val tvShowRecommendation: List<TvShowRecommendation> = emptyList(),
)


data class TvShowRecommendation(
    val id: Int = 0,
    val poster: String = "",
    val seriesName: String = "",
)