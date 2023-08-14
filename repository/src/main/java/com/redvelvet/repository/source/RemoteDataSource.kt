package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto

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
    suspend fun multiSearch(query: String, page : Int?): List<MultiSearchResultDto>
    suspend fun searchPeople(query: String, page : Int?): List<PersonDto>
    suspend fun searchMovie(query: String, page : Int?): List<MovieDto>
    suspend fun searchTvShows(query: String, page : Int?): List<TvShowDto>
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
}