package com.redvelvet.remote.service


import com.redvelvet.repository.dto.BaseResponse
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.tvShow.StatusResponse
import com.redvelvet.repository.dto.tvShow.TvShowDetailsDto
import com.redvelvet.repository.dto.tvShow.TvShowImagesDto
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
import com.redvelvet.repository.dto.tvShow.TvShowRecommendationsDto
import com.redvelvet.repository.dto.tvShow.TvShowReviewsDto
import com.redvelvet.repository.dto.tvShow.TvShowTopCastDto
import com.redvelvet.repository.dto.tvShow.TvShowVideosDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
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
    ): Response<BaseResponse<List<MultiSearchResultDto>>>

    @GET("search/person")
    suspend fun searchPeople(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<PersonDto>>>

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

    // region TvShow
    @GET("/tv/{series_id}")
    suspend fun getTvShowDetailsById(@Path("series_id") seriesId: Int): Response<TvShowDetailsDto>

    @GET("/tv/{series_id}/recommendations")
    suspend fun getTvShowRecommendationsByID(@Path("series_id") seriesId: Int):Response<TvShowRecommendationsDto>

    @GET("/tv/{series_id}/images")
    suspend fun getTvShowImagesByID(@Path("series_id") seriesId: Int):Response<TvShowImagesDto>

    @GET("/tv/{series_id}/videos")
    suspend fun getTvShowVideosByID(@Path("series_id") seriesId: Int):Response<TvShowVideosDto>

    @GET("/tv/{series_id}/reviews")
    suspend fun getTvShowReviewsByID(@Path("series_id") seriesId: Int):Response<TvShowReviewsDto>

    @GET("/tv/{series_id}/keywords")
    suspend fun getTvShowKeyWordsByID(@Path("series_id") seriesId: Int): Response<TvShowKeywordsDto>

    @GET("/tv/{series_id}/credits")
    suspend fun getTvShowTopCastByID(@Path("series_id") seriesId: Int): Response<TvShowTopCastDto>

    @POST("/tv/{series_id}/rating")
    suspend fun addTvShowRating(
        @Field("value") seriesRating: Double,
        @Path("series_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @DELETE("/tv/{series_id}/rating")
    suspend fun deleteTvShowRating(
        @Path("series_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    // endregion

}