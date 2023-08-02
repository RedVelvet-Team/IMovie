package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

internal class GetMovieRecommendationUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId:Int): MovieRecommendations {
        return movieRepository.getMovieRecommendationsByID(movieId)
    }
}
