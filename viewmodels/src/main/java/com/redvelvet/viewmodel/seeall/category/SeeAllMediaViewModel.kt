package com.redvelvet.viewmodel.seeall.category

import androidx.lifecycle.SavedStateHandle
import androidx.paging.PagingData
import androidx.paging.map
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.usecase.category.GetCategoryByIdUseCase
import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.category.CategoryArgs
import com.redvelvet.viewmodel.utils.MediaType
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class SeeAllMediaViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAllCategoryById: GetCategoryByIdUseCase
) : BaseViewModel<SeeAllCategoryUiState, BaseUiEffect>(SeeAllCategoryUiState()) {
    private val args: CategoryArgs = CategoryArgs(savedStateHandle)

    init {
        _state.update { it.copy(title = args.title) }
        when (args.media) {
            MediaType.MOVIE.name -> getAllMovieCategory(id = args.id.toInt())
            MediaType.TV.name -> getAllTvCategory(id = args.id.toInt())
        }
    }

    private fun getAllMovieCategory(id: Int) {
        tryToExecutePaging(
            call = { getAllCategoryById.getCategoryMovieById(id) },
            onSuccess = ::onGetMovieSuccess,
            onError = ::onGetError
        )
    }

    private fun getAllTvCategory(id: Int) {
        tryToExecutePaging(
            call = { getAllCategoryById.getCategoryTvById(id) },
            onSuccess = ::onGetTvSuccess,
            onError = ::onGetError
        )
    }

    private fun onGetMovieSuccess(result: PagingData<Movie>) {
        _state.update {
            it.copy(
                isLoading = false,
                media = flowOf(result.map { it.toMediaUiState() })
            )
        }
    }

    private fun onGetTvSuccess(result: PagingData<TvShow>) {
        _state.update {
            it.copy(
                isLoading = false,
                media = flowOf(result.map { it.toMediaUiState() })
            )
        }
    }

    private fun onGetError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error
            )
        }
    }
}