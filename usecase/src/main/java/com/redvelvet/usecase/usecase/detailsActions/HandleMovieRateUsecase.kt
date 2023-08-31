package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class HandleMovieRateUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,

    ) {
    suspend operator fun invoke(movieRating: Double, movieId: Int): String {
        return if (handleItemCheckUsecase.invoke(movieId, DetailsActionsTypes.RATED_MOVIE)) {
            deleteMovieRating(movieId)
        } else {
            addMovieRate(movieRating, movieId)
        }
    }

    private suspend fun addMovieRate(movieRating: Double, movieId: Int) =
        repository.addMovieRating(
            movieRating,
            movieId,
            userRepository.getUserSessionIdFromLocal()
        )

    private suspend fun deleteMovieRating(movieId: Int) =
        repository.deleteMovieRating(
            movieId, userRepository.getUserSessionIdFromLocal()
        )
}