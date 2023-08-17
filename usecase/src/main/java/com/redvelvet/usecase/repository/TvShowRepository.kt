package com.redvelvet.usecase.repository

import com.redvelvet.entities.tv.TvShowDetails
import com.redvelvet.entities.tv.TvShowImages
import com.redvelvet.entities.tv.TvShowKeywords
import com.redvelvet.entities.tv.TvShowRecommendations
import com.redvelvet.entities.tv.TvShowReviews
import com.redvelvet.entities.tv.TvShowTopCast
import com.redvelvet.entities.tv.TvShowVideos

interface TvShowRepository {
    suspend fun getTvShowKeyWordsByID(seriesId: Int): TvShowKeywords
    suspend fun getTvShowTopCastByID(seriesId: Int): TvShowTopCast
    suspend fun getTvShowVideos(seriesId: Int): TvShowVideos
    suspend fun getTvShowImages(seriesId: Int): TvShowImages
    suspend fun addTvShowRating(seriesRating: Double, seriesId: Int, sessionId: String): String
    suspend fun deleteTvShowRating(seriesId: Int, sessionId: String): String
    suspend fun getTvShowDetailsByID(seriesId: Int): TvShowDetails
    suspend fun getTvShowRecommendationsByID(seriesId: Int): TvShowRecommendations
    suspend fun getTvShowReviewsByID(seriesId: Int): TvShowReviews

}