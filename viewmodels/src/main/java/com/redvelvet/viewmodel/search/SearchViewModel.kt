package com.redvelvet.viewmodel.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.usecase.search.GetAllSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetSearchMoviesUseCase
import com.redvelvet.usecase.usecase.search.GetSearchPeopleUseCase
import com.redvelvet.usecase.usecase.search.GetSearchTvShowUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllSearchResultUseCase: GetAllSearchResultUseCase,
    private val getSearchMoviesUseCase: GetSearchMoviesUseCase,
    private val getSearchPeopleUseCase: GetSearchPeopleUseCase,
    private val getSearchTvShowUseCase: GetSearchTvShowUseCase,
) : BaseViewModel<SearchUiState>(SearchUiState()), SearchListener {

    init {
        onGetData("Iron")
    }
    fun onChangeSearchTextFiled(query: String) {
            // TODO
    }

    private fun onGetData(query: String) {
        Log.v("hassan", "query is sent ${_state.value.toString()}")
        tryToExecutePaging(
            call = { getAllSearchResultUseCase(query).cachedIn(viewModelScope) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(pagingData: PagingData<SearchResult>) {
        _state.update {
            it.copy(
                searchResult = flowOf(pagingData.map { it.toMediaUiState() }),
                isLoading = false,
                isEmpty = false
            )
        }
    }

    private fun onError(errorUiState: ErrorUiState) {
        Log.v("hassan", "errorUiState${_state.value}")
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    fun onChangeCategory(type: SearchMedia) {
        _state.update { it.copy(selectedMediaType = type) }
    }

    private fun onGetError(error: ErrorUiState) {
        _state.update { it.copy(error = error) }
    }

    /// region listeners
    override fun onClickClear() {
        TODO("Not yet implemented")
    }

    override fun showResultAll() {
        TODO("Not yet implemented")
    }

    override fun showResultMovie() {
        TODO("Not yet implemented")
    }

    override fun showResultTv() {
        TODO("Not yet implemented")
    }

    override fun showResultPeople() {
        TODO("Not yet implemented")
    }

    override fun onClickItem(id: Int) {
        TODO("Not yet implemented")
    }
    ///endregion
}