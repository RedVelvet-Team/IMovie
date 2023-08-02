package com.redvelvet.remote.service

import com.redvelvet.repository.dto.auth.DeleteSessionDto
import com.redvelvet.repository.dto.auth.GuestSessionDto
import com.redvelvet.repository.dto.auth.LoginRequest
import com.redvelvet.repository.dto.auth.SessionDto
import com.redvelvet.repository.dto.auth.TokenDto
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieApiService {
    @GET("authentication/token/ne")
    suspend fun getNewRequestToken(): Response<TokenDto>

    @FormUrlEncoded
    @POST("authentication/token/validate_with_login")
    suspend fun validateRequestTokenWithLogin(@Body loginRequest: LoginRequest): Response<TokenDto>

    @FormUrlEncoded
    @POST("authentication/session/new")
    suspend fun createUserSession(@Field("request_token") requestToken: String): Response<SessionDto>

    @GET("authentication/guest_session/new")
    suspend fun createGuestSession(): Response<GuestSessionDto>

    @FormUrlEncoded
    @DELETE("authentication/session")
    suspend fun deleteUserSession(@Field("session_id") sessionId: String): Response<DeleteSessionDto>


    //region Movie Detials
    @GET("/movie/{movie_id}")
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: String): Response<MovieDetailsDTO>
    @GET("/movie/{movie_id}/images")
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: String):Response<MovieImagesDTO>
    @GET("/movie/{movie_id}/keywords")
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: String):Response<MovieKeyWordsDTO>
    @GET("/movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: String):Response<MovieRecommendationsDTO>
    @GET("/movie/{movie_id}/reviews")
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: String):Response<MovieReviewsDTO>
    @GET("/movie/{movie_id}/similar")
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: String):Response<MovieSimilarDTO>
    @GET("/movie/{movie_id}/credits")
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: String):Response<MovieTopCastDto>
    //endregion
}