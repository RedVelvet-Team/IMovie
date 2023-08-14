package com.redvelvet.remote.source

import com.redvelvet.entities.error.BadRequestException
import com.redvelvet.entities.error.NoInternetException
import com.redvelvet.entities.error.NotFoundException
import com.redvelvet.entities.error.NullResultException
import com.redvelvet.entities.error.ServerException
import com.redvelvet.entities.error.ValidationException
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.source.RemoteDataSource
import retrofit2.Response
import java.net.UnknownHostException
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val movieApiService: MovieApiService,
) : RemoteDataSource {

    //region auth
    override suspend fun createGuestSession(): GuestSessionDto {
        return wrapApiResponse {
            movieApiService.createGuestSession()
        }
    }

    override suspend fun createToken(): TokenDto {
        return wrapApiResponse {
            movieApiService.getNewRequestToken()
        }
    }

    override suspend fun validateUserWithLogin(
        userName: String,
        password: String,
        requestToken: String
    ): TokenDto {
        return wrapApiResponse {
            movieApiService.validateRequestTokenWithLogin(
                loginRequest = LoginRequest(
                    username = userName,
                    password = password,
                    requestToken = requestToken,
                )
            )
        }
    }

    override suspend fun createUserSession(token: String): SessionDto {
        return wrapApiResponse {
            movieApiService.createUserSession(token)
        }
    }

    override suspend fun deleteUserSession(sessionId: String): SessionDto {
        return wrapApiResponse {
            movieApiService.deleteUserSession(sessionId)
        }
    }
    //endregion

    // region search
    override suspend fun multiSearch(query: String, page: Int?): List<MultiSearchResultDto> {
        return wrapApiResponse { movieApiService.multiSearch(query, page) }.result.orEmpty()
    }

    override suspend fun searchPeople(query: String, page: Int?): List<PersonDto> {
        return wrapApiResponse { movieApiService.searchPeople(query, page) }.result.orEmpty()
    }

    override suspend fun searchMovie(query: String, page: Int?): List<MovieDto> {
        return wrapApiResponse { movieApiService.searchMovie(query, page) }.result.orEmpty()
    }

    override suspend fun searchTvShows(query: String, page: Int?): List<TvShowDto> {
        return wrapApiResponse { movieApiService.searchTvShows(query, page) }.result.orEmpty()
    }
    // endregion

    //region see all tv
    override suspend fun seeAllAiringTodayTv(page: Int?): List<TvShowDto> {
        return wrapApiResponse { movieApiService.seeAllAiringTodayTv(page) }.result.orEmpty()
    }

    override suspend fun seeAllOnTheAir(page: Int?): List<TvShowDto> {
        return wrapApiResponse { movieApiService.seeAllOnTheAir(page) }.result.orEmpty()
    }

    override suspend fun seeAllPopularTv(page: Int?): List<TvShowDto> {
        return wrapApiResponse { movieApiService.seeAllPopularTv(page) }.result.orEmpty()
    }

    //endregion

    //region wrap response
    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        return try {
            val response = request()
            if (response.isSuccessful) {
                response.body() ?: throw NullResultException("Empty data")
            } else {
                throw when (response.code()) {
                    400 -> BadRequestException(response.message())
                    401 -> ValidationException(response.message())
                    404 -> NotFoundException(response.message())
                    else -> ServerException(response.message())
                }
            }
        } catch (e: UnknownHostException) {
            throw NoInternetException("no Internet")
        }
    }
    //endregion

}

