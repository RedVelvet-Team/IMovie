package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

internal class GetMovieKeyWordUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId:Int): MovieKeyWords {
        return movieRepository.getMovieKeyWordsByID(movieId)
    }
}
