package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.GuestSessionDto
import com.redvelvet.repository.dto.auth.SessionDto
import com.redvelvet.repository.dto.auth.TokenDto
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import retrofit2.http.Path

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


    //region Movie Details
    suspend fun getMovieDetailsById(@Path("movie_id") movieId: Int): MovieDetailsDTO
    suspend fun getMovieImagesByID(@Path("movie_id") movieId: Int): MovieImagesDTO
    suspend fun getMovieKeyWordsByID(@Path("movie_id") movieId: Int): MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(@Path("movie_id") movieId: Int): MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(@Path("movie_id") movieId: Int): MovieReviewsDTO
    suspend fun getMovieSimilarByID(@Path("movie_id") movieId: Int): MovieSimilarDTO
    suspend fun getMovieTopCastByID(@Path("movie_id") movieId: Int): MovieTopCastDto
    //endregion
}