package com.redvelvet.usecase.repository

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.tv.TvShow

interface LibraryRepository {

    suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String,
    ): List<MovieDetails>

    suspend fun getFavoriteTv(
        accountId: Int,
        sessionId: String,
    ): List<TvShow>


    suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String,
    ): List<MovieDetails>

    suspend fun getWatchlistTv(
        accountId: Int,
        sessionId: String,
    ): List<TvShow>

    suspend fun getRatedMovies(
        accountId: Int,
        sessionId: String,
    ): List<MovieDetails>

    suspend fun getRatedTv(
        accountId: Int,
        sessionId: String,
    ): List<TvShow>


}