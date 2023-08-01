package com.redvelvet.remote.service

import com.redvelvet.remote.dto.auth.DeleteSessionDto
import com.redvelvet.remote.dto.auth.GuestSessionDto
import com.redvelvet.remote.dto.auth.LoginRequest
import com.redvelvet.remote.dto.auth.SessionDto
import com.redvelvet.remote.dto.auth.TokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MovieApiService {
    @GET("authentication/token/new")
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
}