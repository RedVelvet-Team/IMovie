package com.redvelvet.repository.repository

import com.redvelvet.entities.tv.TvShowImages
import com.redvelvet.entities.tv.TvShowVideos
import com.redvelvet.repository.mapper.toTvShowDetails
import com.redvelvet.repository.mapper.toTvShowImages
import com.redvelvet.repository.mapper.toTvShowKeywords
import com.redvelvet.repository.mapper.toTvShowRecommendations
import com.redvelvet.repository.mapper.toTvShowReviews
import com.redvelvet.repository.mapper.toTvShowTopCast
import com.redvelvet.repository.mapper.toTvShowVideos
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RealTimeDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.TvShowRepository
import javax.inject.Inject

class TvShowRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: RealTimeDataSource
) : TvShowRepository, BaseRepository() {
    override suspend fun getTvShowKeyWordsByID(seriesId: Int) =
        remoteDataSource.getTvShowKeyWordsByID(seriesId).toTvShowKeywords()


    override suspend fun getTvShowTopCastByID(seriesId: Int) =
        remoteDataSource.getTvShowTopCastByID(seriesId).toTvShowTopCast()

    override suspend fun getTvShowVideos(seriesId: Int): TvShowVideos =
        remoteDataSource.getTvShowVideosByID(seriesId).toTvShowVideos()


    override suspend fun getTvShowImages(seriesId: Int): TvShowImages =
        remoteDataSource.getTvShowImagesByID(seriesId).toTvShowImages()


    override suspend fun addTvShowRating(seriesRating: Double, seriesId: Int, sessionId: String) =
        remoteDataSource.addTvShowRating(seriesRating, seriesId, sessionId)


    override suspend fun deleteTvShowRating(seriesId: Int, sessionId: String) =
        remoteDataSource.deleteTvShowRating(seriesId, sessionId)

    override suspend fun getTvShowDetailsByID(seriesId: Int) =
        remoteDataSource.getTvShowDetailsByID(seriesId).toTvShowDetails()


    override suspend fun getTvShowRecommendationsByID(seriesId: Int) =
        remoteDataSource.getTvShowRecommendationsByID(seriesId).toTvShowRecommendations()


    override suspend fun getTvShowReviewsByID(seriesId: Int) =
        remoteDataSource.getTvShowReviewsByID(seriesId).toTvShowReviews()


}
