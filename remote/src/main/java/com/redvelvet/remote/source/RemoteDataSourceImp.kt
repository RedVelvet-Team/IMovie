package com.redvelvet.remote.source

import android.util.Log
import com.google.gson.Gson
import com.redvelvet.entities.error.ErrorType
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.BaseSearchDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.series.SeriesDto
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.util.RemoteError
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService
) : RemoteDataSource {

    // region search
    override suspend fun multiSearch(query: String, page: Int?): List<MultiSearchResultDto> {
        return wrapApiResponse { movieApiService.multiSearch(query, page) }.result ?: throw ErrorType.NullData
    }

    override suspend fun searchPeople(query: String, page: Int?): List<PersonDto> {
        return wrapApiResponse { movieApiService.searchPeople(query, page) }.result
            ?: throw ErrorType.NullData
    }

    override suspend fun searchMovie(query: String, page: Int?): List<MovieDto> {
        return wrapApiResponse { movieApiService.searchMovie(query, page) }.result
            ?: throw ErrorType.NullData
    }

    override suspend fun searchTvShows(query: String, page: Int?): List<SeriesDto> {
        return wrapApiResponse { movieApiService.searchTvShows(query, page) }.result
            ?: throw ErrorType.NullData
    }

    // endregion


    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body() ?: throw RemoteError.NullData
            } else {
                throw remoteErrorMap[getErrorCodeFromJson(response.errorBody()?.string() ?: "")]!!
            }
        } catch (e: Exception) {
            throw RemoteError.Network
        }
    }
}

private fun getErrorCodeFromJson(json: String): Int {
    return Gson().fromJson(json, ErrorResponseDto::class.java).code ?: 0
}