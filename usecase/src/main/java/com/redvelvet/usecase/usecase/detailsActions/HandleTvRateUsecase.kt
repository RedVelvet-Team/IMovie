package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.usecase.library.GetRatedTvUsecase
import javax.inject.Inject

class HandleTvRateUsecase @Inject constructor(
    private val getRatedTvUsecase: GetRatedTvUsecase,
    private val addTvRateUsecase: AddTvShowRatingUseCase,
    private val deleteTvShowRatingUseCase: DeleteTvShowRatingUseCase,
) {
    suspend operator fun invoke(seriesRating: Double, seriesId: Int): String {
        val isListHasItem = getRatedTvUsecase.invoke().any { it.id == seriesId }
        return if (isListHasItem) {
            deleteTvShowRatingUseCase.invoke(seriesId)
        } else {
            addTvRateUsecase.invoke(seriesRating, seriesId)
        }
    }
}