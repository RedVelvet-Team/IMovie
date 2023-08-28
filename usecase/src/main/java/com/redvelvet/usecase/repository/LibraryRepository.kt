package com.redvelvet.usecase.repository

import com.redvelvet.entities.library.LibraryMovie
import com.redvelvet.entities.library.LibraryTv

interface LibraryRepository {

    suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovie>

    suspend fun getFavoriteTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTv>


    suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovie>

    suspend fun getWatchlistTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTv>

    suspend fun getRatedMovies(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovie>

    suspend fun getRatedTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTv>


}