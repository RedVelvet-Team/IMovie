package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto

import com.redvelvet.repository.dto.movie.details.*

interface RemoteDataSource {
    //region auth
    suspend fun createGuestSession(): GuestSessionDto
    suspend fun createToken(): TokenDto
    suspend fun validateUserWithLogin(userName: String, password: String, requestToken: String): TokenDto
    suspend fun createUserSession(token: String): SessionDto
    suspend fun deleteUserSession(sessionId: String): SessionDto
    //endregion

    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetailsDTO
    suspend fun getMovieImagesByID(movieId: Int):MovieImagesDTO
    suspend fun getMovieKeyWordsByID(movieId: Int):MovieKeyWordsDTO
    suspend fun getMovieRecommendationsByID(movieId: Int):MovieRecommendationsDTO
    suspend fun getMovieReviewsByID(movieId: Int):MovieReviewsDTO
    suspend fun getMovieSimilarByID(movieId: Int):MovieSimilarDTO
    suspend fun getMovieTopCastByID(movieId: Int):MovieTopCastDTO
    //endregion

}