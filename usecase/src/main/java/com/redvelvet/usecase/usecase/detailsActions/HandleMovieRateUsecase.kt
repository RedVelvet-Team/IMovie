package com.redvelvet.usecase.usecase.detailsActions

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class HandleMovieRateUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val addMovieRateUsecase: AddMovieRatingUseCase,
    private val deleteMovieRatingUseCase: DeleteMovieRatingUseCase,
) {
    suspend operator fun invoke(movieRating: Double, movieId: Int): String {
        return coroutineScope {
            if (handleItemCheckUsecase.invoke(movieId, TypeOfData.RATED_MOVIE)) {
                deleteMovieRatingUseCase.invoke(movieId)
            } else {
                addMovieRateUsecase.invoke(movieRating, movieId)
            }
        }
    }
}