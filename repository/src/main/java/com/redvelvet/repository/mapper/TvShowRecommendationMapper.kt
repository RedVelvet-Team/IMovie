package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowRecommendation
import com.redvelvet.entities.tv.TvShowRecommendations
import com.redvelvet.repository.dto.tvShow.TvShowRecommendationResult
import com.redvelvet.repository.dto.tvShow.TvShowRecommendationsDto
import com.redvelvet.repository.localDto.TvShowRecommendationLocalDto
import com.redvelvet.repository.localDto.TvShowRecommendationsLocalDto

fun TvShowRecommendationsDto.toTvShowRecommendationsLocalDto() = TvShowRecommendationsLocalDto(
    tvShowRecommendation = results?.map {
        it?.toTvShowRecommendationLocalDto() ?: TvShowRecommendationLocalDto()
    } ?: emptyList()
)

fun TvShowRecommendationResult.toTvShowRecommendationLocalDto() = TvShowRecommendationLocalDto(
    poster = posterPath ?: "",
    seriesName = name ?: ""
)

fun TvShowRecommendationsDto.toTvShowRecommendations() = TvShowRecommendations(
    tvShowRecommendation = results?.map { it?.toTvShowRecommendation() ?: TvShowRecommendation() }
        ?: emptyList()
)

fun TvShowRecommendationResult.toTvShowRecommendation() = TvShowRecommendation(
    poster = posterPath ?: "",
    seriesName = name ?: ""
)