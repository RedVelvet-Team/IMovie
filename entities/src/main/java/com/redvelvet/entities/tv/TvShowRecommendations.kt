package com.redvelvet.entities.tv

data class TvShowRecommendations(
    val tvShowRecommendation: List<TvShowRecommendation> = emptyList(),
)


data class TvShowRecommendation(
    val poster: String = "",
    val seriesName: String = "",
)