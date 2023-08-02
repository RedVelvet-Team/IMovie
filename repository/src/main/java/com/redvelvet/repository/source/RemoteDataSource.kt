package com.redvelvet.repository.source

import com.redvelvet.repository.dto.movie.details.*
import retrofit2.http.Path

interface RemoteDataSource {

    //region Movie Details
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: String): MovieDetailsDTO
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: String):MovieImagesDTO
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: String):MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: String):MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: String):MovieReviewsDTO
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: String):MovieSimilarDTO
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: String):MovieTopCastDto
    //endregion

}