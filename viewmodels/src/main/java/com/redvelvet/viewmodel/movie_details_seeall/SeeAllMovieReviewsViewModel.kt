package com.redvelvet.viewmodel.movie_details_seeall

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllMovieReviewsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : BaseViewModel<SeeAllReviewsUiState, Unit>(SeeAllReviewsUiState()) {

    private val args: AllReviewArgs = AllReviewArgs(savedStateHandle)

    init {
        getMovieReviews(args.id.toInt())
    }

    private fun getMovieReviews(movieId: Int) {
        tryToExecute(
            execute = { getMovieFullDetailsUseCase.getReviewsByID(movieId) },
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