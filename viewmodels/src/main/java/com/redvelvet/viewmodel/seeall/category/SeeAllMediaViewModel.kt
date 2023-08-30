package com.redvelvet.viewmodel.seeall.category

import androidx.lifecycle.SavedStateHandle
import androidx.paging.PagingData
import androidx.paging.map
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.usecase.category.GetCategoryByIdUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.category.SeeALlMediaArgs
import com.redvelvet.viewmodel.utils.MediaType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllMediaViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAllCategoryById: GetCategoryByIdUseCase
) : BaseViewModel<SeeAllCategoryUiState, SeeAllCategoriesUiEffect>(SeeAllCategoryUiState()),
    SeeAllCategoriesInteraction {
    private val args: SeeALlMediaArgs = SeeALlMediaArgs(savedStateHandle)

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

    override fun onCLickRefresh() {
        _state.update { it.copy(title = args.title) }
        when (args.media) {
            MediaType.MOVIE.name -> getAllMovieCategory(id = args.id.toInt())
            MediaType.TV.name -> getAllTvCategory(id = args.id.toInt())
        }
    }

    override fun onClickBack() {
        sendUiEffect(SeeAllCategoriesUiEffect.NavigateUp)
    }

    override fun onClickItem(id: String) {
        when (args.media) {
            MediaType.MOVIE.name -> sendUiEffect(
                SeeAllCategoriesUiEffect.NavigateToMovieDetailsScreen(
                    id = id
                )
            )

            MediaType.TV.name -> sendUiEffect(
                SeeAllCategoriesUiEffect.NavigateToTvDetailsScreen(
                    id = id
                )
            )
        }

    }


}