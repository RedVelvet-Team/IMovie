package com.redvelvet.repository.source

import com.redvelvet.repository.dto.movie.details.*

interface RemoteDataSource {

    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetailsDTO
    suspend fun getMovieImagesByID(movieId: Int):MovieImagesDTO
    suspend fun getMovieKeyWordsByID(movieId: Int):MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(movieId: Int):MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(movieId: Int):MovieReviewsDTO
    suspend fun getMovieSimilarByID(movieId: Int):MovieSimilarDTO
    suspend fun getMovieTopCastByID(movieId: Int):MovieTopCastDTO
    //endregion

}