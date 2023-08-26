package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class AddTvShowRatingUseCase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(seriesRating: Double, seriesId: Int) =
        repository.addTvShowRating(
            seriesRating,
            seriesId,
            userRepository.getUserSessionIdFromLocal()
        )
}