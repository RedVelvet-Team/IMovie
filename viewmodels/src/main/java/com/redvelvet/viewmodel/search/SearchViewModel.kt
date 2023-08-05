package com.redvelvet.viewmodel.search

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.usecase.search.GetSearchResultUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase,
) : BaseViewModel<SearchUiState>(SearchUiState()), SearchListener {
    private val _searchState: MutableStateFlow<PagingData<SearchUiState>> = MutableStateFlow(value = PagingData.empty())
    val searchState = _searchState.asStateFlow()

    fun onChangeSearchTextFiled(query: String) {
        _state.update { it.copy(inputText = query, isLoading = true, isEmpty = false) }
        viewModelScope.launch {
            _state.debounce(1000).collect{
                when (it.selectedMediaType) {
                    SearchMedia.MOVIE -> {}
                    SearchMedia.PEOPLE -> {}
                    SearchMedia.TV -> {}
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
        viewModelScope.launch {
            getSearchResultUseCase(_state.value.inputText)
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {

                }
        }
//        tryToExecute(
//            function = { getSearchResultUseCase(_state.value.inputText) },
//            onSuccess = ::onGetSuccess,
//            onError = ::onGetError
//        )
    }
    /// endregion

    /// region Search for movie
//    private fun onSearchForMovie() {
//        tryToExecute(
//            function = {
//                getSearchResultUseCase.searchMovie(_state.value.inputText)
//            },
//            onSuccess = ::onGetSuccess,
//            onError = ::onGetError
//        )
//    }
    /// endregion

    /// region Search for TvShow
//    private fun onSearchForTvShow() {
//        tryToExecute(
//            function = {
//                getSearchResultUseCase.searchTvShows(_state.value.inputText)
//            },
//            onSuccess = ::onGetSuccess,
//            onError = ::onGetError
//        )
//    }
    /// endregion

    /// region Search for Person
//    private fun onSearchForPerson() {
//        tryToExecute(
//            function = {
//                getSearchResultUseCase.searchPeople(_state.value.inputText)
//            },
//            onSuccess = ::onGetSuccess,
//            onError = ::onGetError
//        )
//    }
    /// endregion

//    private fun onGetSuccess(result: Flow<PagingData<List<SearchResult>>>) {
//        viewModelScope.launch {
//            val searchResult = result.collect {it.map { it.map { it.toMediaUiState() } }}
//        }
//        _state.update { it -> it.copy(searchResult = result.collect {it.map { it.map { it.toMediaUiState() } }}) }
//    }

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