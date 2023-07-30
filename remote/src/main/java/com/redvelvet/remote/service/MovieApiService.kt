package com.redvelvet.remote.service

import com.redvelvet.remote.dto.BaseResponse
import com.redvelvet.remote.dto.Pagination
import com.redvelvet.remote.dto.auth.GuestSessionDto
import com.redvelvet.remote.dto.auth.LoginRequest
import com.redvelvet.remote.dto.auth.SessionDto
import com.redvelvet.remote.dto.auth.TokenDto
import com.redvelvet.remote.dto.movie.MovieDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Query

interface MovieApiService {
    @GET("authentication/token/new")
    suspend fun getRequestToken(): Response<TokenDto>

    @POST("authentication/token/validate_with_login")
    suspend fun validateRequestTokenWithLogin(@Body loginRequest: LoginRequest): Response<TokenDto>

    @FormUrlEncoded
    @POST("authentication/session/new")
    suspend fun createSession(@Field("request_token") requestToken: String): Response<SessionDto>

    @GET("authentication/guest_session/new")
    suspend fun createGuestSession(): Response<GuestSessionDto>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "authentication/session", hasBody = true)
    suspend fun deleteSession(@Field("session_id") sessionId: String): Response<BaseResponse>

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