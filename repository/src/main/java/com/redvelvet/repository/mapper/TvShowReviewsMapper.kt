package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowReview
import com.redvelvet.entities.tv.TvShowReviews
import com.redvelvet.repository.dto.tvShow.ResultReview
import com.redvelvet.repository.dto.tvShow.TvShowReviewsDto
import com.redvelvet.repository.localDto.TvShowReviewLocalDto
import com.redvelvet.repository.localDto.TvShowReviewsLocalDto

fun TvShowReviewsDto.toTvShowReviewsLocalDto() = TvShowReviewsLocalDto(
    tvShowReviews = results?.map { it?.toTvShowReviewLocalDto() ?: TvShowReviewLocalDto() }
        ?: emptyList()
)

fun ResultReview.toTvShowReviewLocalDto() = TvShowReviewLocalDto(
    author = author ?: "",
    rating = authorDetails?.rating ?: 0.0 ,
    createdAt = createdAt ?: "",
    content = content ?: ""
)


fun TvShowReviewsDto.toTvShowReviews() = TvShowReviews(
    tvShowReviews = results?.map { it?.toTvShowReview() ?: TvShowReview()} ?: emptyList()
)

fun ResultReview.toTvShowReview() = TvShowReview(
    author = author ?: "",
    rating = authorDetails?.rating ?: 0.0,
    createdAt = createdAt ?: "",
    content = content ?: ""
)