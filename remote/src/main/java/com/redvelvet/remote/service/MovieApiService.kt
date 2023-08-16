package com.redvelvet.remote.service


import com.redvelvet.repository.dto.ActorKnownForDto
import com.redvelvet.repository.dto.BaseResponse
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.ActorDto
import com.redvelvet.repository.dto.search.CombinedResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    //region auth
    @GET("authentication/token/new")
    suspend fun getNewRequestToken(): Response<TokenDto>

    @POST("authentication/token/validate_with_login")
    suspend fun validateRequestTokenWithLogin(@Body loginRequest: LoginRequest): Response<TokenDto>

    @FormUrlEncoded
    @POST("authentication/session/new")
    suspend fun createUserSession(@Field("request_token") requestToken: String): Response<SessionDto>

    @GET("authentication/guest_session/new")
    suspend fun createGuestSession(): Response<GuestSessionDto>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "authentication/session", hasBody = true)
    suspend fun deleteUserSession(@Field("session_id") sessionId: String): Response<SessionDto>
    //endregion

    // region search
    @GET("search/multi")
    suspend fun multiSearch(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<CombinedResultDto>>>

    @GET("search/person")
    suspend fun searchPeople(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<ActorDto>>>

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDto>>>

    @GET("search/tv")
    suspend fun searchTvShows(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("person/{person_id}")
    suspend fun getActorDetails(
        @Path("person_id") id: String
    ): Response<ActorDto>

    @GET("person/{person_id}/combined_credits")
    suspend fun getActorKnownFor(
        @Path("person_id") id: String
    ): Response<ActorKnownForDto>
}