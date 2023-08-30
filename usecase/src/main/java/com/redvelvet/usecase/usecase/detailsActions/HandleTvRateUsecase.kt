package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class HandleTvRateUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(seriesRating: Double, seriesId: Int): String {
        return if (handleItemCheckUsecase.invoke(seriesId, DetailsActionsTypes.RATED_MOVIE)) {
            deleteTvShowRating(seriesId)
        } else {
            addTvRate(seriesRating, seriesId)
        }
    }

    private suspend fun addTvRate(seriesRating: Double, seriesId: Int) =
        repository.addTvShowRating(
            seriesRating,
            seriesId,
            userRepository.getUserSessionIdFromLocal()
        )

    private suspend fun deleteTvShowRating(seriesId: Int) =
        repository.deleteTvShowRating(
            seriesId, userRepository.getUserSessionIdFromLocal()
        )
}