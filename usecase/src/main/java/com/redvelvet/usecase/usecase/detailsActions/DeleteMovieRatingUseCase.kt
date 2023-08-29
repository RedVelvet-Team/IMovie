package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class DeleteMovieRatingUseCase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(movieId: Int) =
        repository.deleteMovieRating(
            movieId, userRepository.getUserSessionIdFromLocal()
        )
}