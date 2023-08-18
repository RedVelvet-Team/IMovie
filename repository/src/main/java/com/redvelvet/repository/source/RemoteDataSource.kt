package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
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
    suspend fun validateUserWithLogin(userName: String, password: String, requestToken: String): TokenDto
    suspend fun createUserSession(token: String): SessionDto
    suspend fun deleteUserSession(sessionId: String): SessionDto
    //endregion

    //region Search
    suspend fun multiSearch(query: String, page : Int?): List<CombinedResultDto>
    suspend fun searchPeople(query: String, page : Int?): List<ActorDto>
    suspend fun searchMovie(query: String, page : Int?): List<MovieDetailsDTO>
    suspend fun searchTvShows(query: String, page : Int?): List<TvShowDto>
    //endregion

    //region see all tv
    suspend fun seeAllAiringTodayTv(page: Int?): List<TvShowDto>
    suspend fun seeAllOnTheAir(page: Int?): List<TvShowDto>
    suspend fun seeAllPopularTv(page: Int?): List<TvShowDto>

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


    //region tvShow
    suspend fun getTvShowKeyWordsByID(seriesId: Int): TvShowKeywordsDto
    suspend fun getTvShowTopCastByID(seriesId: Int): TvShowTopCastDto
    suspend fun addTvShowRating(
        seriesRating: Double,
        seriesId: Int,
        sessionId: String
    ): String
    suspend fun getTvShowVideosByID(seriesId: Int): TvShowVideosDto
    suspend fun getTvShowImagesByID(seriesId: Int): TvShowImagesDto
    suspend fun deleteTvShowRating(seriesId: Int, sessionId: String): String

    suspend fun getTvShowDetailsByID(seriesId: Int): TvShowDetailsDto
    suspend fun getTvShowRecommendationsByID(seriesId: Int): TvShowRecommendationsDto
    suspend fun getTvShowReviewsByID(seriesId: Int): TvShowReviewsDto
    suspend fun getAllSeasons(seriesId: Int): TvShowDetailsDto
    //endregion
}