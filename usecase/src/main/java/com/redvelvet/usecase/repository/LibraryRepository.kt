package com.redvelvet.usecase.repository

import com.redvelvet.entities.library.WatchListMedia

interface LibraryRepository {

    suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia

    suspend fun getFavoriteTv(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia


    suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia

    suspend fun getWatchlistTv(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia

    suspend fun getRatedMovies(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia

    suspend fun getRatedTv(
        accountId: Int,
        sessionId: String,
    ): WatchListMedia


}