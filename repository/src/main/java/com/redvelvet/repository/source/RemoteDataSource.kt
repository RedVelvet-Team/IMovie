package com.redvelvet.repository.source

import com.redvelvet.repository.dto.movie.details.*
import retrofit2.http.Path

interface RemoteDataSource {

    //region Movie Details
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: Int): MovieDetailsDTO
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: Int):MovieImagesDTO
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: Int):MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: Int):MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: Int):MovieReviewsDTO
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: Int):MovieSimilarDTO
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: Int):MovieTopCastDto
    //endregion

}