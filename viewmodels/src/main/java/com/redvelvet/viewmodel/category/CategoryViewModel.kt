package com.redvelvet.viewmodel.category

import android.util.Log
import com.redvelvet.entities.Genre
import com.redvelvet.usecase.usecase.category.GetCategoryUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategory: GetCategoryUseCase,
) : BaseViewModel<MediaTypeUiState, Unit>(MediaTypeUiState()) {


    init {
        getMovieCategory()
    }

    private fun onMediaTypeChange(name: String) {
        _state.update {
            it.copy(
                type = listOf("Movies", "TV Shows"),
                isLoading = true,
                error = null
            )
        }
        when (name) {
            "Movie" -> getMovieCategory()
            "TV Shows" -> getTvCategory()
            else -> {}
        }
    }

    private fun getMovieCategory() {
        tryToExecute(
            execute = { getCategory.getCategoryMovie() },
            onSuccessWithData = ::onSuccessGetCategoryGenre,
            onError = ::onError
        )
    }

    private fun getTvCategory() {
        tryToExecute(
            execute = { getCategory.getCategoryTv() },
            onSuccessWithData = ::onSuccessGetCategoryGenre,
            onError = ::onError
        )
    }

    private fun onSuccessGetCategoryGenre(mediaType: List<Genre>) {
        mediaType.forEach {
            Log.v("AAA", it.toString())
        }

        _state.update {
            it.copy(
                isLoading = false,
                genreList = mediaType.map { it.toGenreUiState() }
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error,
            )
        }
    }
}