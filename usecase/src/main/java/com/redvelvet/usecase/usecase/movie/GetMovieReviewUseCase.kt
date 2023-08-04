package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetMovieReviewUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId:Int): MovieReviews {
        return movieRepository.getMovieReviewsByID(movieId)
    }
}
