package com.redvelvet.entities.tv

data class TvShowAllDetails(
    val tvShowId: Int = 0,
    val tvShowName: String = "",
    val tvShowImage: String = "",
    val tvShowLanguage: String = "",
    val tvShowDescription: String = "",
    val genres: List<String> = emptyList(),
    val tvShowTrailerUrl: String = "",
    val voteAverage: Double = 0.0,
    val firstAirDate: String = "",
    val topCast: List<TvShowCast> = emptyList(),
    val keywords: List<String> = emptyList(),
    val seasons: List<SeasonTvShow> = emptyList(),
    val reviews: List<TvShowReview> = emptyList(),
    val posters: List<String> = emptyList(),
    val videos: List<TvShowResultVideo> = emptyList(),
    val recommendations: List<TvShowRecommendation> = emptyList(),
)