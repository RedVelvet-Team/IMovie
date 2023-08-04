package com.redvelvet.viewmodel.search

import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.usecase.search.GetSearchResultUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase,
) : BaseViewModel<SearchUiState>(SearchUiState()), SearchListener {

    fun onChangeSearchTextFiled(query: String) {
        _state.update { it.copy(inputText = query, isLoading = true, isEmpty = false) }
        viewModelScope.launch {
            _state.debounce(1000).collect{
                when (it.selectedMediaType) {
                    SearchMedia.MOVIE -> onSearchForMovie()
                    SearchMedia.PEOPLE -> onSearchForPerson()
                    SearchMedia.TV -> onSearchForTvShow()
                    SearchMedia.ALL -> onSearchForAll()
                }
            }
        }
    }

    fun onChangeCategory(type: SearchMedia){
        _state.update { it.copy(selectedMediaType = type) }
    }

    /// region Search for All
    private fun onSearchForAll() {
        tryToExecute(
            function = { getSearchResultUseCase(_state.value.inputText) },
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }
    /// endregion

    /// region Search for movie
    private fun onSearchForMovie() {
        tryToExecute(
            function = {
                getSearchResultUseCase.searchMovie(_state.value.inputText)
            },
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }
    /// endregion

    /// region Search for TvShow
    private fun onSearchForTvShow() {
        tryToExecute(
            function = {
                getSearchResultUseCase.searchTvShows(_state.value.inputText)
            },
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }
    /// endregion

    /// region Search for Person
    private fun onSearchForPerson() {
        tryToExecute(
            function = {
                getSearchResultUseCase.searchPeople(_state.value.inputText)
            },
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }
    /// endregion

    private fun onGetSuccess(result: List<SearchResult>) {
        _state.update { it -> it.copy(searchResult = result.map { it.toMediaUiState() }) }
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