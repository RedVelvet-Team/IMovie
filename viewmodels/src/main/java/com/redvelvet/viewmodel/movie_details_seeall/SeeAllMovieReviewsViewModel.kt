package com.redvelvet.viewmodel.movie_details_seeall

import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllMovieReviewsViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : BaseViewModel<SeeAllReviewsUiState, Unit>(SeeAllReviewsUiState()) {
    private val movieId: Int = 2


    init {
        getMovieImages(movieId)
    }

    private fun getMovieImages(movieId: Int) {
        tryToExecute(
            execute = { getMovieFullDetailsUseCase.getMovieReviewsByID(movieId) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(movieResult: MovieReviews) {
        _state.update {
            it.copy(
                isLoading = false,
                reviews = movieResult.results.map { it.toMovieReviewsUiState() },

                )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error
            )
        }
    }

}