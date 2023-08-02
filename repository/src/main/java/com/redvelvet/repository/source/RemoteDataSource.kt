package com.redvelvet.repository.source

import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteDataSource {

    //region Movie Details
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: String): MovieDto
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: String):MovieImagesDTO
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: String):MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: String):MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: String):MovieReviewsDTO
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: String):MovieSimilarDTO
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: String):MovieTopCastDto
    //endregion

}