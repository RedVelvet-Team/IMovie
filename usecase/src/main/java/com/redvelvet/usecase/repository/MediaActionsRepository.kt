package com.redvelvet.usecase.repository

interface MediaActionsRepository {
    suspend fun toggleMediaInWatchList(
        mediaType: String,
        mediaId: Int,
        isSavedInWatchList: Boolean,
        accountId: Int,
        sessionId: String
    ): String

    suspend fun toggleMediaInFavorites(
        mediaType: String,
        mediaId: Int,
        isSavedInFavorites: Boolean,
        accountId: Int,
        sessionId: String
    ): String

    suspend fun addTvShowRating(seriesRating: Double, seriesId: Int, sessionId: String): String

    suspend fun deleteTvShowRating(seriesId: Int, sessionId: String): String

    suspend fun addMovieRating(movieRating: Double, movieId: Int, sessionId: String): String

    suspend fun deleteMovieRating(movieId: Int, sessionId: String): String

}