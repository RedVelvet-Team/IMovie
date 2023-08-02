package com.redvelvet.remote.source

import com.google.gson.Gson
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.util.RemoteError
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService
) : RemoteDataSource {

    //region Movie Details
    override suspend fun getMovieDetailsById(movieId: String): MovieDto {
        return wrapApiResponse {
            movieApiService.getMovieDetailsById(movieId)
        }
    }

    override suspend fun getMovieImagesByID(movieId: String): MovieImagesDTO {
        return wrapApiResponse {
            movieApiService.getMovieImagesByID(movieId)
        }    }

    override suspend fun getMovieKeyWordsByID(movieId: String): MovieKeyWordsDTO {
        return wrapApiResponse {
            movieApiService.getMovieKeyWordsByID(movieId)
        }    }

    override suspend fun getMovieRecommendationsByID(movieId: String): MovieRecommendationsDTO {
        return wrapApiResponse {
            movieApiService.getMovieRecommendationsByID(movieId)
        }    }

    override suspend fun getMovieReviewsByID(movieId: String): MovieReviewsDTO {
        return wrapApiResponse {
            movieApiService.getMovieReviewsByID(movieId)
        }    }

    override suspend fun getMovieSimilarByID(movieId: String): MovieSimilarDTO {
        return wrapApiResponse {
            movieApiService.getMovieSimilarByID(movieId)
        }    }

    override suspend fun getMovieTopCastByID(movieId: String): MovieTopCastDto {
        return wrapApiResponse {
            movieApiService.getMovieTopCastByID(movieId)
        }
    }
    //endregion

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