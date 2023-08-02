package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

internal class GetMovieSimilarUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId:Int): MovieSimilar {
        return movieRepository.getMovieSimilarByID(movieId)
    }
}
