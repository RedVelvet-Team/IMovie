package com.redvelvet.remote.source

import com.google.gson.Gson
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.util.RemoteError
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService,
    private val gson: Gson,
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

    //region wrap response
    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        return try {
            val response = request()
            if (response.isSuccessful) {
                response.body() ?: throw RemoteError.NullData
            } else {
                val errorCode: Int? =
                    getErrorCodeFromJson(response.errorBody()?.string().toString())
                throw remoteErrorMap[errorCode ?: 0]!!
            }
        } catch (e: RemoteError) {
            throw e
        } catch (e: Exception) {
            throw RemoteError.Network
        }
    }

    private fun getErrorCodeFromJson(json: String): Int? {
        return gson.fromJson(json, ErrorResponseDto::class.java).code ?: 0
    }
    //endregion

}

