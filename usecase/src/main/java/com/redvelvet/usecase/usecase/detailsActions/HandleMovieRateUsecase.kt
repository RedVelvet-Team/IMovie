package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.usecase.library.GetRatedMovieUsecase
import javax.inject.Inject

class HandleMovieRateUsecase @Inject constructor(
    private val getRatedMovieUsecase: GetRatedMovieUsecase,
    private val addMovieRateUsecase: AddMovieRatingUseCase,
    private val deleteMovieRatingUseCase: DeleteMovieRatingUseCase,
) {
    suspend operator fun invoke(movieRating: Double, movieId: Int): String {
        val isListHasItem = getRatedMovieUsecase.invoke().any { it.id == movieId }
        return if (isListHasItem) {
            deleteMovieRatingUseCase.invoke(movieId)
        } else {
            addMovieRateUsecase.invoke(movieRating, movieId)
        }
    }
}