package com.redvelvet.viewmodel.movie_details_seeall

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllTopCastViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : BaseViewModel<SeeAllTopCastUiState, Unit>(SeeAllTopCastUiState()){

    private val args: TopCastArgs = TopCastArgs(savedStateHandle)


    init {
        getTopCast(args.id.toInt())
    }

    private fun getTopCast(movieId: Int) {
        tryToExecute(
            execute = { getMovieFullDetailsUseCase.getMovieTopCastByID(movieId) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(movieResult : MovieTopCast) {
        _state.update {
            it.copy(
                isLoading = false,
                topCast = movieResult.cast.map { it.toMovieTopCastUiState() } ,

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