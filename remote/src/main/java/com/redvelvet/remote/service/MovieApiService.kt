package com.redvelvet.remote.service

import com.redvelvet.repository.dto.auth.DeleteSessionDto
import com.redvelvet.repository.dto.auth.GuestSessionDto
import com.redvelvet.repository.dto.auth.LoginRequest
import com.redvelvet.repository.dto.auth.SessionDto
import com.redvelvet.repository.dto.auth.TokenDto
import com.redvelvet.repository.dto.search.BaseSearchDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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

    @GET("search/multi")
    suspend fun multiSearch(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseSearchDto>
}