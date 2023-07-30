package com.redvelvet.remote.service

import com.redvelvet.remote.dto.Pagination
import com.redvelvet.remote.dto.movie.MovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int? = 1,
    ): Response<Pagination<MovieDto>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int? = 1,
    ): Response<Pagination<MovieDto>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int? = 1,
    ): Response<Pagination<MovieDto>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int? = 1,
    ): Response<Pagination<MovieDto>>
}