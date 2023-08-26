package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class AddMovieRatingUseCase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(movieRating: Double, movieId: Int) =
        repository.addMovieRating(
            movieRating,
            movieId,
            userRepository.getUserSessionIdFromLocal()
        )
}