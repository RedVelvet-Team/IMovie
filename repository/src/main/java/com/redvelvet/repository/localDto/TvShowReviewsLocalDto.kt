package com.redvelvet.repository.localDto



data class TvShowReviewsLocalDto(
    val tvShowReviews: List<TvShowReviewLocalDto> = emptyList()
)


data class TvShowReviewLocalDto(
    val author: String = "",
    val rating: Double = 0.0,
    val  createdAt: String = "",
    val content: String = "",
)