package com.redvelvet.remote.source

import com.redvelvet.entities.error.BadRequestException
import com.redvelvet.entities.error.NoInternetException
import com.redvelvet.entities.error.NotFoundException
import com.redvelvet.entities.error.NullResultException
import com.redvelvet.entities.error.ServerException
import com.redvelvet.entities.error.ValidationException
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.repository.dto.ActorKnownForDto
import com.redvelvet.repository.dto.SeasonDetailsDto
import com.redvelvet.repository.dto.auth.request.LoginRequest
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
import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.dto.tvShow.TvShowImagesDto
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
import com.redvelvet.repository.dto.tvShow.TvShowTopCastDto
import com.redvelvet.repository.dto.tvShow.TvShowVideosDto
import com.redvelvet.repository.source.RemoteDataSource
import okio.IOException
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

    //region Movie Details
    override suspend fun getMovieDetailsById(movieId: Int): MovieDetailsDTO {
        return wrapApiResponse {
            movieApiService.getMovieDetailsById(movieId)
        }
    }

    override suspend fun getMovieImagesByID(movieId: Int): MovieImagesDTO {
        return wrapApiResponse {
            movieApiService.getMovieImagesByID(movieId)
        }
    }

    override suspend fun getMovieKeyWordsByID(movieId: Int): MovieKeyWordsDTO {
        return wrapApiResponse {
            movieApiService.getMovieKeyWordsByID(movieId)
        }
    }

    override suspend fun getMovieRecommendationsByID(movieId: Int): MovieRecommendationsDTO {
        return wrapApiResponse {
            movieApiService.getMovieRecommendationsByID(movieId)
        }
    }

    override suspend fun getMovieReviewsByID(movieId: Int): MovieReviewsDTO {
        return wrapApiResponse {
            movieApiService.getMovieReviewsByID(movieId)
        }
    }

    override suspend fun getMovieSimilarByID(movieId: Int): MovieSimilarDTO {
        return wrapApiResponse {
            movieApiService.getMovieSimilarByID(movieId)
        }
    }

    override suspend fun getMovieTopCastByID(movieId: Int): MovieTopCastDto {
        return wrapApiResponse {
            movieApiService.getMovieTopCastByID(movieId)
        }
    }
    //endregion

    // region search
    override suspend fun multiSearch(query: String, page: Int?): List<CombinedResultDto> {
        return wrapApiResponse { movieApiService.multiSearch(query, page) }.result.orEmpty()
    }

    override suspend fun searchPeople(query: String, page: Int?): List<ActorDto> {
        return wrapApiResponse { movieApiService.searchPeople(query, page) }.result.orEmpty()
    }

    override suspend fun searchMovie(query: String, page: Int?): List<MovieDetailsDTO> {
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

    override suspend fun seeAllTopRatedTv(page: Int?): List<TvShowDto> {
        return wrapApiResponse { movieApiService.seeAllTopRatedTv(page) }.result.orEmpty()
    }

    override suspend fun seeAllRecommendedTv(page: Int?, id: Int): List<TvShowDto> {
        return wrapApiResponse { movieApiService.seeAllRecommendedMovieTv(id = id, page = page) }.result.orEmpty()
    }

    override suspend fun getActorDetails(id: String): ActorDto {
        return wrapApiResponse { movieApiService.getActorDetails(id) }
    }

    override suspend fun getActorKnownFor(id: String): ActorKnownForDto {
        return wrapApiResponse { movieApiService.getActorKnownFor(id) }
    }

    override suspend fun getAllEpisodes(tvId: String, seasonNumber: Int): SeasonDetailsDto {
        return wrapApiResponse { movieApiService.getAllEpisodes(tvId, seasonNumber) }
    }

    // endregion
    //region see all
    override suspend fun seeAllPopularMovie(page: Int?): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllPopularMovie(page) }.result.orEmpty()
    }

    override suspend fun seeAllUpcomingMovie(page: Int?): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllUpcomingMovie(page) }.result.orEmpty()
    }

    override suspend fun seeAllNowPlayingMovie(page: Int?): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllNowPlayingMovie(page) }.result.orEmpty()
    }

    override suspend fun seeAllTopRatedMovie(page: Int?): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllTopRatedMovie(page) }.result.orEmpty()
    }

    override suspend fun seeAllSimilarMovie(page: Int?, id: Int): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllSimilarMovie(id, page) }.result.orEmpty()
    }

    override suspend fun seeAllRecommendedMovie(page: Int?, id: Int): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.seeAllRecommendedMovie(id, page) }.result.orEmpty()
    }
    //endregion

    //region wrap response
    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body() ?: throw NullResultException("No data")
            } else {
                throw when (response.code()) {
                    400 -> BadRequestException(response.message())
                    401 -> ValidationException("Invalid username or password")
                    404 -> NotFoundException("Not found")
                    else -> ServerException("Server error")
                }
            }
        } catch (e: UnknownHostException) {
            throw NoInternetException("no Internet")
        } catch (io: IOException) {
            throw NoInternetException(io.message)
        }
    }
    //endregion


    //region tvShow
    override suspend fun getTvShowKeyWordsByID(seriesId: Int): TvShowKeywordsDto =
        wrapApiResponse { movieApiService.getTvShowKeyWordsByID(seriesId) }


    override suspend fun getTvShowTopCastByID(seriesId: Int): TvShowTopCastDto =
        wrapApiResponse { movieApiService.getTvShowTopCastByID(seriesId) }


    override suspend fun addTvShowRating(
        seriesRating: Double,
        seriesId: Int,
        sessionId: String
    ): String =
        wrapApiResponse {
            movieApiService.addTvShowRating(
                seriesRating,
                seriesId,
                sessionId
            )
        }.statusMessage.toString()

    override suspend fun getTvShowVideosByID(seriesId: Int): TvShowVideosDto =
        wrapApiResponse { movieApiService.getTvShowVideosByID(seriesId) }

    override suspend fun getTvShowImagesByID(seriesId: Int): TvShowImagesDto =
        wrapApiResponse { movieApiService.getTvShowImagesByID(seriesId) }


    override suspend fun deleteTvShowRating(seriesId: Int, sessionId: String): String =
        wrapApiResponse {
            movieApiService.deleteTvShowRating(
                seriesId,
                sessionId
            )
        }.statusMessage.toString()

    override suspend fun getTvShowDetailsByID(seriesId: Int) =
        wrapApiResponse { movieApiService.getTvShowDetailsById(seriesId) }


    override suspend fun getTvShowRecommendationsByID(seriesId: Int) =
        wrapApiResponse { movieApiService.getTvShowRecommendationsByID(seriesId) }


    override suspend fun getTvShowReviewsByID(seriesId: Int) =
        wrapApiResponse { movieApiService.getTvShowReviewsByID(seriesId) }

    override suspend fun getPopularMovies(): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.getPopularMovie(1) }
    }

    override suspend fun getUpComingMovies(): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.getUpcomingMovie() }
    }

    override suspend fun getTopRatedMovies(): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.getTopRatedMovie() }
    }

    override suspend fun getNowPlayingMovies(): List<MovieDetailsDTO> {
        return wrapApiResponse { movieApiService.getNowPlayingMovie() }
    }
    //endregion

}

