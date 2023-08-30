package com.redvelvet.remote.service


import com.redvelvet.remote.BuildConfig
import com.redvelvet.repository.dto.BaseResponse
import com.redvelvet.repository.dto.GenresDto
import com.redvelvet.repository.dto.EpisodeSingleItemDto
import com.redvelvet.repository.dto.SeasonDetailsDto
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.AccountDetailsDto
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.detailsRequests.AddToWatchListRequest
import com.redvelvet.repository.dto.detailsRequests.MarkAsFavoriteRequest
import com.redvelvet.repository.dto.detailsRequests.RateRequest
import com.redvelvet.repository.dto.library.LibraryMovieDto
import com.redvelvet.repository.dto.library.LibraryTvDto
import com.redvelvet.repository.dto.listAndFavorites.AddMediaToListDto
import com.redvelvet.repository.dto.listAndFavorites.CreateUserListDto
import com.redvelvet.repository.dto.listAndFavorites.DeleteMovieFromListDto
import com.redvelvet.repository.dto.listAndFavorites.FavoriteRequestDto
import com.redvelvet.repository.dto.listAndFavorites.ListRemoteDto
import com.redvelvet.repository.dto.listAndFavorites.ListResponseDto
import com.redvelvet.repository.dto.listAndFavorites.UserListDto
import com.redvelvet.repository.dto.listAndFavorites.WatchlistDto
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.person.ActorDto
import com.redvelvet.repository.dto.schema.ImagesDto
import com.redvelvet.repository.dto.schema.RecommendationsDto
import com.redvelvet.repository.dto.schema.ReviewDto
import com.redvelvet.repository.dto.schema.TopCastDto
import com.redvelvet.repository.dto.search.CombinedResultDto
import com.redvelvet.repository.dto.tvShow.StatusResponse
import com.redvelvet.repository.dto.tvShow.TvShowDetailsDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
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

    //region Movie Details
    @GET("movie/{movie_id}")
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: Int): Response<MovieDetailsDTO>

    @GET("movie/{movie_id}/images")
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: Int): Response<ImagesDto>

    @GET("movie/{movie_id}/keywords")
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: Int): Response<MovieKeyWordsDTO>

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: Int): Response<RecommendationsDto>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: Int): Response<ReviewDto>

    @GET("movie/{movie_id}/similar")
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: Int): Response<MovieSimilarDTO>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: Int): Response<TopCastDto>

    //endregion
    @HTTP(method = "DELETE", path = "authentication/session", hasBody = true)
    suspend fun deleteUserSession(@Field("session_id") sessionId: String): Response<SessionDto>

    @GET("account")
    suspend fun getAccountDetails(
        @Query("session_id") sessionId: String,
    ): Response<AccountDetailsDto>

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
    //endregion

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

    @GET("tv/top_rated")
    suspend fun seeAllTopRatedTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/{tv_id}/recommendations")
    suspend fun seeAllRecommendedMovieTv(
        @Path("tv_id") id: Int,
        @Query("page") page: Int? = 1
    ): Response<BaseResponse<List<TvShowDto>>>

    //endregion

    /// region see all episodes
    @GET("tv/{tv_id}/season/{season_number}")
    suspend fun getAllEpisodes(
        @Path("tv_id") tvId: String,
        @Path("season_number") seasonNumber: Int
    ): Response<SeasonDetailsDto>
    // endregion

    // region person
    @GET("person/{person_id}")
    suspend fun getActorDetails(
        @Path("person_id") id: String
    ): Response<ActorDto>

    @GET("person/{person_id}/combined_credits")
    suspend fun getActorKnownFor(
        @Path("person_id") id: String
    ): Response<ActorKnownForDto>

    // endregion

    // region TvShow
    @GET("tv/{tv_id}")
    suspend fun getTvShowDetailsById(@Path("tv_id") seriesId: Int): Response<TvShowDetailsDto>

    @GET("tv/{tv_id}/recommendations")
    suspend fun getTvShowRecommendationsByID(@Path("tv_id") seriesId: Int): Response<RecommendationsDto>

    @GET("tv/{tv_id}/images")
    suspend fun getTvShowImagesByID(@Path("tv_id") seriesId: Int): Response<ImagesDto>

    @GET("tv/{tv_id}/videos")
    suspend fun getTvShowVideosByID(@Path("tv_id") seriesId: Int): Response<TvShowVideosDto>

    @GET("tv/{tv_id}/reviews")
    suspend fun getTvShowReviewsByID(@Path("tv_id") seriesId: Int): Response<ReviewDto>

    @GET("tv/{tv_id}/keywords")
    suspend fun getTvShowKeyWordsByID(@Path("tv_id") seriesId: Int): Response<TvShowKeywordsDto>

    @GET("tv/{tv_id}/credits")
    suspend fun getTvShowTopCastByID(@Path("tv_id") seriesId: Int): Response<TopCastDto>
    // endregion

    // region Episode Details
    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}")
    suspend fun getEpisodeDetails(
        @Path("tv_id") tvID: Int,
        @Path("season_number") seasonNumber: Int,
        @Path("episode_number") episodeNumber: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<EpisodeSingleItemDto.EpisodeDetails>

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/videos")
    suspend fun getEpisodeMovies(
        @Path("tv_id") tvID: Int,
        @Path("season_number") seasonNumber: Int,
        @Path("episode_number") episodeNumber: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<EpisodeSingleItemDto.EpisodeMovies>

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/credits")
    suspend fun getEpisodeTopCast(
        @Path("tv_id") tvID: Int,
        @Path("season_number") seasonNumber: Int,
        @Path("episode_number") episodeNumber: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<EpisodeSingleItemDto.EpisodeCast>

    @GET("tv/{tv_id}/season/{season_number}/episode/{episode_number}/images")
    suspend fun getEpisodeImages(
        @Path("tv_id") tvID: Int,
        @Path("season_number") seasonNumber: Int,
        @Path("episode_number") episodeNumber: Int,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<EpisodeSingleItemDto.EpisodeImages>

    //endregion

    //region see all
    @GET("movie/popular")
    suspend fun seeAllPopularMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/upcoming")
    suspend fun seeAllUpcomingMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/now_playing")
    suspend fun seeAllNowPlayingMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/top_rated")
    suspend fun seeAllTopRatedMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/{movie_id}/similar")
    suspend fun seeAllSimilarMovie(
        @Path("movie_id") id: Int,
        @Query("page") page: Int? = 1
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/{movie_id}/recommendations")
    suspend fun seeAllRecommendedMovie(
        @Path("movie_id") id: Int,
        @Query("page") page: Int? = 1
    ): Response<BaseResponse<List<MovieDetailsDTO>>>
    //endregion

    //region movies
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>
    //endregion

    //region get tv categories
    @GET("tv/airing_today")
    suspend fun getAiringTodayTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/popular")
    suspend fun getPopularTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("tv/top_rated")
    suspend fun getTopRatedTv(
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>
    //endregion

    // region details actions
    @POST("tv/{tv_id}/rating")
    suspend fun addTvShowRating(
        @Body rateRequest: RateRequest,
        @Path("tv_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @DELETE("tv/{tv_id}/rating")
    suspend fun deleteTvShowRating(
        @Path("tv_id") seriesId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @POST("movie/{movie_id}/rating")
    suspend fun addMovieRating(
        @Body rateRequest: RateRequest,
        @Path("movie_id") movieId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @DELETE("movie/{movie_id}/rating")
    suspend fun deleteMovieRating(
        @Path("movie_id") movieId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @POST("account/{account_id}/watchlist")
    suspend fun toggleMediaInWatchlist(
        @Body addToWatchListRequest: AddToWatchListRequest,
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>

    @POST("account/{account_id}/favorite")
    suspend fun toggleMediaInFavoriteList(
        @Body markAsFavoriteRequest: MarkAsFavoriteRequest,
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<StatusResponse>


    //endregion

    //region my list
    @GET("account/account_id/lists")
    suspend fun getUserLists(): Response<BaseResponse<UserListDto>>

    @POST("list/{list_id}/add_item")
    suspend fun postUserMedia(
        @Path("list_id") listId: Int,
        @Body mediaId: AddMediaToListDto
    ): Response<StatusResponse>

    @POST("list")
    suspend fun createUserList(@Body name: CreateUserListDto): Response<StatusResponse>

    @GET("account/{account_id}/favorite/movies")
    suspend fun getFavoriteMovies(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryMovieDto>>>

    @GET("account/{account_id}/favorite/tv")
    suspend fun getFavoriteTv(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryTvDto>>>


    @GET("account/{account_id}/watchlist/movies")
    suspend fun getWatchlistMovie(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryMovieDto>>>

    @GET("account/{account_id}/watchlist/tv")
    suspend fun getWatchlistTv(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryTvDto>>>

    @GET("account/{account_id}/rated/movies")
    suspend fun getRatedMovies(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryMovieDto>>>

    @GET("account/{account_id}/rated/tv")
    suspend fun getRatedTv(
        @Path("account_id") accountId: Int,
        @Query("session_id") sessionId: String,
    ): Response<BaseResponse<List<LibraryTvDto>>>


    @POST("account/{account_id}/watchlist")
    suspend fun addWatchlist(
        @Body watchlistRequest: WatchlistDto,
    ): Response<StatusResponse>

    @POST("list")
    suspend fun addList(@Body listRequest: CreateUserListDto): Response<ListResponseDto>

    @DELETE("list/{list_id}")
    suspend fun deleteList(@Path("list_id") listId: Int): Response<StatusResponse>

    @GET("account/{account_id}/lists")
    suspend fun getLists(): Response<BaseResponse<ListRemoteDto>>

    @GET("list/{list_id}")
    suspend fun getDetailsList(@Path("list_id") listId: Int)
            : Response<BaseResponse<MovieDetailsDTO>>

    @POST("list/{list_id}/remove_item")
    suspend fun deleteMovieDetailsList(
        @Path("list_id") listId: Int,
        @Body movieRequest: DeleteMovieFromListDto,
    ): Response<StatusResponse>

    @POST("account/account_id/favorite")
    suspend fun addFavorite(
        @Body markAsFavorite: FavoriteRequestDto,
        @Path("account_id") accountId: Int,
    ): Response<StatusResponse>
    //endregion
    // endregion

    //region Category
    @GET("genre/movie/list")
    suspend fun genreListMovie(
        @Query("page") page: Int? = 1,
    ): Response<GenresDto>

    @GET("genre/tv/list")
    suspend fun genreListTv(
        @Query("page") page: Int? = 1,
    ): Response<GenresDto>

    @GET("discover/tv")
    suspend fun discoverListTv(
        @Query("with_genres") id: Int,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<TvShowDto>>>

    @GET("discover/movie")
    suspend fun discoverListMovie(
        @Query("with_genres") id: Int,
        @Query("page") page: Int? = 1,
    ): Response<BaseResponse<List<MovieDetailsDTO>>>
    //endregion
}