package com.redvelvet.repository.repository

import com.redvelvet.entities.library.WatchListMedia
import com.redvelvet.repository.mapper.toDomain
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.LibraryRepository
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : LibraryRepository, BaseRepository() {
    override suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String
    ): WatchListMedia {
        return remoteDataSource.getFavoriteMovies(accountId, sessionId).toDomain()
    }

    override suspend fun getFavoriteTv(accountId: Int, sessionId: String): WatchListMedia {
        return remoteDataSource.getFavoriteTv(accountId, sessionId).toDomain()
    }

    override suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String
    ): WatchListMedia {
        return remoteDataSource.getWatchlistMovie(accountId, sessionId).toDomain()
    }

    override suspend fun getWatchlistTv(accountId: Int, sessionId: String): WatchListMedia {
        return remoteDataSource.getWatchlistTv(accountId, sessionId).toDomain()
    }

    override suspend fun getRatedMovies(accountId: Int, sessionId: String): WatchListMedia {
        return remoteDataSource.getRatedMovies(accountId, sessionId).toDomain()
    }

    override suspend fun getRatedTv(accountId: Int, sessionId: String): WatchListMedia {
        return remoteDataSource.getRatedTv(accountId, sessionId).toDomain()
    }

}