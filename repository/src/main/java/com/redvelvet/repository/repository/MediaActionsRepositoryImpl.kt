package com.redvelvet.repository.repository

import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MediaActionsRepository
import javax.inject.Inject

class MediaActionsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : BaseRepository(), MediaActionsRepository {
    override suspend fun toggleMediaInWatchList(
        mediaType: String,
        mediaId: Int,
        isSavedInWatchList: Boolean,
        accountId: Int,
        sessionId: String
    ) =
        remoteDataSource.toggleMediaInWatchlist(
            mediaType = mediaType,
            mediaId = mediaId,
            watchlist = isSavedInWatchList,
            sessionId = sessionId,
            accountId = accountId,
        )


    override suspend fun toggleMediaInFavorites(
        mediaType: String,
        mediaId: Int,
        isSavedInFavorites: Boolean,
        accountId: Int,
        sessionId: String
    ) =
        remoteDataSource.toggleMediaInFavorite(
            mediaType = mediaType,
            mediaId = mediaId,
            favorite = isSavedInFavorites,
            sessionId = sessionId,
            accountId = accountId,

            )


    override suspend fun addTvShowRating(seriesRating: Double, seriesId: Int, sessionId: String) =
        remoteDataSource.addTvShowRating(seriesRating, seriesId, sessionId)


    override suspend fun deleteTvShowRating(seriesId: Int, sessionId: String) =
        remoteDataSource.deleteTvShowRating(seriesId, sessionId)

    override suspend fun addMovieRating(movieRating: Double, movieId: Int, sessionId: String) =
        remoteDataSource.addMovieRating(movieRating, movieId, sessionId)


    override suspend fun deleteMovieRating(movieId: Int, sessionId: String): String =
        remoteDataSource.deleteTvShowRating(movieId, sessionId)


}