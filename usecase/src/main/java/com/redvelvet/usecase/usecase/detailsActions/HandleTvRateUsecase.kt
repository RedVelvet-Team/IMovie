package com.redvelvet.usecase.usecase.detailsActions

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class HandleTvRateUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val addTvRateUsecase: AddTvShowRatingUseCase,
    private val deleteTvShowRatingUseCase: DeleteTvShowRatingUseCase,
) {
    suspend operator fun invoke(seriesRating: Double, seriesId: Int): String {
        return coroutineScope {
            if (handleItemCheckUsecase.invoke(seriesId, TypeOfData.RATED_MOVIE)) {
                deleteTvShowRatingUseCase.invoke(seriesId)
            } else {
                addTvRateUsecase.invoke(seriesRating, seriesId)
            }
        }
    }
}