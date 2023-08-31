package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowRecommendation
import com.redvelvet.entities.tv.TvShowRecommendations
import com.redvelvet.repository.dto.schema.RecommendationsDto
import com.redvelvet.repository.localDto.TvShowRecommendationLocalDto
import com.redvelvet.repository.localDto.TvShowRecommendationsLocalDto

fun RecommendationsDto.toTvShowRecommendationsLocalDto() = TvShowRecommendationsLocalDto(
    tvShowRecommendation = results.map { it.toTvShowRecommendationLocalDto() }
)

fun RecommendationsDto.Result.toTvShowRecommendationLocalDto() = TvShowRecommendationLocalDto(
    poster = posterPath ?: "",
    seriesName = originalTitle ?: ""
)

fun RecommendationsDto.toTvShowRecommendations() = TvShowRecommendations(
    tvShowRecommendation = results.map { it.toTvShowRecommendation() }
        ?: emptyList()
)

fun RecommendationsDto.Result.toTvShowRecommendation() = TvShowRecommendation(
    id = id ?: 0,
    poster = posterPath ?: "",
    seriesName = originalTitle ?: ""
)