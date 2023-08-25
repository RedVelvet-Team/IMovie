package com.redvelvet.repository.repository

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.mapper.toDomain
import com.redvelvet.repository.mapper.toMovie
import com.redvelvet.repository.mapper.toTvShow
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.LibraryRepository
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : LibraryRepository, BaseRepository() {
    override suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String
    ): List<MovieDetails> {
        return remoteDataSource.getFavoriteMovies(accountId, sessionId).map { it.toDomain() }
    }

    override suspend fun getFavoriteTv(accountId: Int, sessionId: String): List<TvShow> {
        return remoteDataSource.getFavoriteTv(accountId, sessionId).map { it.toTvShow() }
    }

    override suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String
    ): List<MovieDetails> {
        return remoteDataSource.getWatchlistMovie(accountId, sessionId).map { it.toDomain() }
    }

    override suspend fun getWatchlistTv(accountId: Int, sessionId: String): List<TvShow> {
        return remoteDataSource.getWatchlistTv(accountId, sessionId).map { it.toTvShow() }
    }

    override suspend fun getRatedMovies(accountId: Int, sessionId: String): List<MovieDetails> {
        return remoteDataSource.getRatedMovies(accountId, sessionId).map { it.toDomain() }
    }

    override suspend fun getRatedTv(accountId: Int, sessionId: String): List<TvShow> {
        return remoteDataSource.getRatedTv(accountId, sessionId).map { it.toTvShow() }
    }

}