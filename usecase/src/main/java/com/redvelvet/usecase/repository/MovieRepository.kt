package com.redvelvet.usecase.repository

import com.redvelvet.entities.movie.details.*

interface MovieRepository {


    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetails
    suspend fun getMovieImagesByID(movieId: Int): MovieImages
    suspend fun getMovieKeyWordsByID(movieId: Int):MovieKeyWords
    suspend fun getMovieRecommendationsByID(movieId: Int):MovieRecommendations
    suspend fun getMovieReviewsByID(movieId: Int):MovieReviews
    suspend fun getMovieSimilarByID(movieId: Int):MovieSimilar
    suspend fun getMovieTopCastByID(movieId: Int):MovieTopCast
    //endregion
}