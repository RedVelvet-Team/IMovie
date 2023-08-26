package com.redvelvet.repository.source

import com.redvelvet.repository.dto.ActorKnownForDto
import com.redvelvet.repository.dto.BaseResponse
import com.redvelvet.repository.dto.SeasonDetailsDto
import com.redvelvet.repository.dto.auth.response.AccountDetailsDto
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.library.LibraryMovieDto
import com.redvelvet.repository.dto.library.LibraryTvDto
import com.redvelvet.repository.dto.listAndFavorites.ListRemoteDto
import com.redvelvet.repository.dto.GenreDto
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import com.redvelvet.repository.dto.person.ActorDto
import com.redvelvet.repository.dto.search.CombinedResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDetailsDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.tvShow.TvShowImagesDto
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
import com.redvelvet.repository.dto.tvShow.TvShowRecommendationsDto
import com.redvelvet.repository.dto.tvShow.TvShowReviewsDto
import com.redvelvet.repository.dto.tvShow.TvShowTopCastDto
import com.redvelvet.repository.dto.tvShow.TvShowVideosDto

interface RemoteDataSource {
    //region auth
    suspend fun createGuestSession(): GuestSessionDto
    suspend fun createToken(): TokenDto
    suspend fun validateUserWithLogin(
        userName: String,
        password: String,
        requestToken: String
    ): TokenDto

    suspend fun createUserSession(token: String): SessionDto
    suspend fun deleteUserSession(sessionId: String): SessionDto
    //endregion

    //region Search
    suspend fun multiSearch(query: String, page: Int?): List<CombinedResultDto>
    suspend fun searchPeople(query: String, page: Int?): List<ActorDto>
    suspend fun searchMovie(query: String, page: Int?): List<MovieDetailsDTO>
    suspend fun searchTvShows(query: String, page: Int?): List<TvShowDto>
    //endregion

    //region see all tv
    suspend fun seeAllAiringTodayTv(page: Int?): List<TvShowDto>
    suspend fun seeAllOnTheAir(page: Int?): List<TvShowDto>
    suspend fun seeAllPopularTv(page: Int?): List<TvShowDto>
    suspend fun seeAllTopRatedTv(page: Int?): List<TvShowDto>
    suspend fun seeAllRecommendedTv(page: Int?, id: Int): List<TvShowDto>


    //endregion


    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetailsDTO
    suspend fun getMovieImagesByID(movieId: Int): MovieImagesDTO
    suspend fun getMovieKeyWordsByID(movieId: Int): MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(movieId: Int): MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(movieId: Int): MovieReviewsDTO
    suspend fun getMovieSimilarByID(movieId: Int): MovieSimilarDTO
    suspend fun getMovieTopCastByID(movieId: Int): MovieTopCastDto
    //endregion

    suspend fun getActorDetails(id: String): ActorDto

    suspend fun getActorKnownFor(id: String): ActorKnownForDto
    suspend fun getAllEpisodes(tvId: String, seasonNumber: Int): SeasonDetailsDto


    //region see all
    suspend fun seeAllPopularMovie(page: Int?): List<MovieDetailsDTO>
    suspend fun seeAllUpcomingMovie(page: Int?): List<MovieDetailsDTO>
    suspend fun seeAllNowPlayingMovie(page: Int?): List<MovieDetailsDTO>
    suspend fun seeAllSimilarMovie(page: Int?, id: Int): List<MovieDetailsDTO>
    suspend fun seeAllTopRatedMovie(page: Int?): List<MovieDetailsDTO>
    suspend fun seeAllRecommendedMovie(page: Int?, id: Int): List<MovieDetailsDTO>
    //endregion


    //region tvShow
    suspend fun getTvShowKeyWordsByID(seriesId: Int): TvShowKeywordsDto
    suspend fun getTvShowTopCastByID(seriesId: Int): TvShowTopCastDto
    suspend fun getTvShowVideosByID(seriesId: Int): TvShowVideosDto
    suspend fun getTvShowImagesByID(seriesId: Int): TvShowImagesDto

    suspend fun getTvShowDetailsByID(seriesId: Int): TvShowDetailsDto
    suspend fun getTvShowRecommendationsByID(seriesId: Int): TvShowRecommendationsDto
    suspend fun getTvShowReviewsByID(seriesId: Int): TvShowReviewsDto
    suspend fun getAllSeasons(seriesId: Int): TvShowDetailsDto
    //endregion

    //region movies
    suspend fun getPopularMovies(): List<MovieDetailsDTO>
    suspend fun getUpComingMovies(): List<MovieDetailsDTO>
    suspend fun getTopRatedMovies(): List<MovieDetailsDTO>
    suspend fun getNowPlayingMovies(): List<MovieDetailsDTO>
    //endregion

    suspend fun getAiringTodayTv(): List<TvShowDto>
    suspend fun getOnTheAir(): List<TvShowDto>
    suspend fun getPopularTv(): List<TvShowDto>
    suspend fun getTopRatedTv(): List<TvShowDto>

    //region Category
    suspend fun getMovieCategory(): List<GenreDto>
    suspend fun getTvCategory(): List<GenreDto>
    suspend fun getMovieCategoryById(page: Int?, id: Int): List<MovieDetailsDTO>
    suspend fun getTvCategoryById(page: Int?, id: Int): List<TvShowDto>
    //endregion


    // region details actions

    suspend fun deleteTvShowRating(seriesId: Int, sessionId: String): String
    suspend fun addTvShowRating(
        seriesRating: Double,
        seriesId: Int,
        sessionId: String
    ): String

    suspend fun deleteMovieRating(movieId: Int, sessionId: String): String
    suspend fun addMovieRating(
        movieRating: Double,
        movieId: Int,
        sessionId: String
    ): String

    suspend fun toggleMediaInWatchlist(
        mediaType: String,
        mediaId: Int,
        watchlist: Boolean,
        sessionId: String,
        accountId: Int,
    ): String

    suspend fun getAccountDetails(
        sessionId: String,
    ): AccountDetailsDto

    suspend fun toggleMediaInFavorite(
        mediaType: String,
        mediaId: Int,
        favorite: Boolean,
        sessionId: String,
        accountId: Int,
    ): String

    // endregion


    suspend fun getFavoriteMovies(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovieDto>

    suspend fun getFavoriteTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTvDto>


    suspend fun getWatchlistMovie(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovieDto>

    suspend fun getWatchlistTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTvDto>

    suspend fun getRatedMovies(
        accountId: Int,
        sessionId: String,
    ): List<LibraryMovieDto>

    suspend fun getRatedTv(
        accountId: Int,
        sessionId: String,
    ): List<LibraryTvDto>


}