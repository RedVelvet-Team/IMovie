package com.redvelvet.usecase.repository

import com.redvelvet.entities.movie.details.*

interface MovieRepository {


    //region Movie Details
    suspend fun getMovieDetailsById(movieId: String): MovieDetails
    suspend fun getMovieImagesByID(movieId: String): MovieImages
    suspend fun getMovieKeyWordsByID(movieId: String):MovieKeyWords
    suspend fun getMovieRecommendationsByID(movieId: String):MovieRecommendations
    suspend fun getMovieReviewsByID(movieId: String):MovieReviews
    suspend fun getMovieSimilarByID(movieId: String):MovieSimilar
    suspend fun getMovieTopCastByID(movieId: String):MovieTopCast
    //endregion
}