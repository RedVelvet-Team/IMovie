package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowReview
import com.redvelvet.entities.tv.TvShowReviews
import com.redvelvet.repository.dto.schema.ReviewDto
import com.redvelvet.repository.dto.schema.ReviewResult
import com.redvelvet.repository.localDto.TvShowReviewLocalDto
import com.redvelvet.repository.localDto.TvShowReviewsLocalDto

fun ReviewDto.toTvShowReviewsLocalDto() = TvShowReviewsLocalDto(
    tvShowReviews = results.map { it.toTvShowReviewLocalDto() }
)

fun ReviewResult.toTvShowReviewLocalDto() = TvShowReviewLocalDto(
    author = author ?: "",
    rating = authorDetails?.rating ?: 0.0,
    createdAt = createdAt ?: "",
    content = content ?: ""
)


fun ReviewDto.toTvShowReviews() = TvShowReviews(
    tvShowReviews = results.map { it.toTvShowReview() }
)

fun ReviewResult.toTvShowReview() = TvShowReview(
    author = author ?: "",
    rating = authorDetails?.rating ?: 0.0,
    createdAt = createdAt ?: "",
    content = content ?: ""
)