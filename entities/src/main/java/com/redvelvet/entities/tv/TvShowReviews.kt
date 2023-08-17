package com.redvelvet.entities.tv

data class TvShowReviews(
    val tvShowReviews: List<TvShowReview> = emptyList()
)


data class TvShowReview(
    val author: String = "",
    val rating: Double = 0.0,
    val  createdAt: String = "",
    val content: String = "",
)