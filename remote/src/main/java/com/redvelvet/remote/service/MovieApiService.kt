package com.redvelvet.remote.service


import com.redvelvet.repository.dto.ActorKnownForDto
import com.redvelvet.repository.dto.BaseResponse
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.person.ActorDto
import com.redvelvet.repository.dto.search.CombinedResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.StatusResponse
import com.redvelvet.repository.dto.tvShow.TvShowDetailsDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.tvShow.TvShowImagesDto
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
import com.redvelvet.repository.dto.tvShow.TvShowRecommendationsDto
import com.redvelvet.repository.dto.tvShow.TvShowReviewsDto
import com.redvelvet.repository.dto.tvShow.TvShowTopCastDto
import com.redvelvet.repository.dto.tvShow.TvShowVideosDto
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

    //region Movie Details
    @GET("movie/{movie_id}")
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: Int): Response<MovieDetailsDTO>

    @GET("movie/{movie_id}/images")
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: Int): Response<MovieImagesDTO>

    @GET("movie/{movie_id}/keywords")
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: Int): Response<MovieKeyWordsDTO>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: Int): Response<MovieRecommendationsDTO>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: Int): Response<MovieReviewsDTO>

    @GET("movie/{movie_id}/similar")
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: Int): Response<MovieSimilarDTO>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: Int): Response<MovieTopCastDto>

    //endregion
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
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("search/tv")
    suspend fun searchTvShows(
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    //region see all tv
    @GET("tv/airing_today")
    suspend fun seeAllAiringTodayTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/on_the_air")
    suspend fun seeAllOnTheAir(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/popular")
    suspend fun seeAllPopularTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    //endregion

    @GET("person/{person_id}")
    suspend fun getActorDetails(
        @Path("person_id") id: String
    ): Response<ActorDto>

    @GET("person/{person_id}/combined_credits")
    suspend fun getActorKnownFor(
        @Path("person_id") id: String
    ): Response<ActorKnownForDto>

    // region TvShow
    @GET("tv/{tv_id}")
    suspend fun getTvShowDetailsById(@Path("tv_id") seriesId: Int): Response<TvShowDetailsDto>

    @GET("tv/{tv_id}/recommendations")
    suspend fun getTvShowRecommendationsByID(@Path("tv_id") seriesId: Int): Response<TvShowRecommendationsDto>

    @GET("tv/{tv_id}/images")
    suspend fun getTvShowImagesByID(@Path("tv_id") seriesId: Int): Response<TvShowImagesDto>

    @GET("tv/{tv_id}/videos")
    suspend fun getTvShowVideosByID(@Path("tv_id") seriesId: Int): Response<TvShowVideosDto>

    @GET("tv/{tv_id}/reviews")
    suspend fun getTvShowReviewsByID(@Path("tv_id") seriesId: Int): Response<TvShowReviewsDto>

    @GET("tv/{tv_id}/keywords")
    suspend fun getTvShowKeyWordsByID(@Path("tv_id") seriesId: Int): Response<TvShowKeywordsDto>

    @GET("tv/{tv_id}/credits")
    suspend fun getTvShowTopCastByID(@Path("tv_id") seriesId: Int): Response<TvShowTopCastDto>

    @POST("tv/{tv_id}/rating")
    suspend fun addTvShowRating(
        @Field("value") seriesRating: Double,
        @Path("tv_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @DELETE("tv/{tv_id}/rating")
    suspend fun deleteTvShowRating(
        @Path("tv_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>
    // endregion

}