package com.redvelvet.viewmodel.category

import com.redvelvet.entities.Genre
import com.redvelvet.usecase.usecase.category.GetCategoryUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.MediaType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategory: GetCategoryUseCase,
) : BaseViewModel<MediaTypeUiState, CategoryUiEffect>(MediaTypeUiState()),
    CategoryInteraction {


    init {
        getMovieCategory()
        getTvCategory()
    }

    private fun getMovieCategory() {
        tryToExecute(
            execute = { getCategory.getCategoryMovie() },
            onSuccessWithData = ::onSuccessGetCategoryGenreMovie,
            onError = ::onError
        )
    }

    private fun getTvCategory() {
        tryToExecute(
            execute = { getCategory.getCategoryTv() },
            onSuccessWithData = ::onSuccessGetCategoryGenreTv,
            onError = ::onError
        )
    }

    private fun onSuccessGetCategoryGenreTv(mediaType: List<Genre>) {
        _state.update {
            it.copy(
                isLoading = false,
                genreTvList = mediaType.map { it.toGenreUiState() },
            )
        }
    }

    private fun onSuccessGetCategoryGenreMovie(mediaType: List<Genre>) {
        _state.update {
            it.copy(
                isLoading = false,
                genreMovieList = mediaType.map { it.toGenreUiState() }
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

    override fun onClickCard(categoryId: String, categoryName: String) {
        sendUiEffect(
            CategoryUiEffect.NavigateToSeeAllCategoryScreen(
                id = categoryId,
                name = categoryName,
            )
        )
    }


    override fun onChangeCategoryTab(mediaType: MediaType) {
        _state.update {
            it.copy(
                type = mediaType,
            )
        }
    }


    override fun onCLickRefresh() {
        getMovieCategory()
        getTvCategory()
    }

}