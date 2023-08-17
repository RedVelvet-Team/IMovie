package com.redvelvet.viewmodel.movie_details_seeall

import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SeeAllMovieImagesViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : BaseViewModel<SeeAllImagesUiState, Unit>(SeeAllImagesUiState()) {
    private val movieId: Int = 2


    init {
        getMovieImages(movieId)
    }

    private fun getMovieImages(movieId: Int) {
        tryToExecute(
            execute = { getMovieFullDetailsUseCase.getMovieImagesByID(movieId) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(movieResult: MovieImages) {
        _state.update {
            it.copy(
                isLoading = false,
                images = movieResult.posters.map { it.toMovieImagesUiState() },

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