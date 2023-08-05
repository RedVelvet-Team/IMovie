package com.redvelvet.viewmodel.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.flatMap
import androidx.paging.map
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.usecase.search.GetSearchResultUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchResultUseCase: GetSearchResultUseCase,
) : BaseViewModel<SearchUiState>(SearchUiState()), SearchListener {

    init {
        onGetData("q")
    }
    fun onChangeSearchTextFiled(query: String) {
//        _state.update { it.copy(inputText = query, isLoading = true, isEmpty = false) }
//        viewModelScope.launch {
//            _state.debounce(1000).collect {
//                onGetData()
//            }
//        }
    }

    private fun onGetData(query: String) {
        Log.v("hassan", "query is sent ${_state.value.toString()}")
        tryToExecutePaging(
            call = { getSearchResultUseCase(query).cachedIn(viewModelScope) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(pagingData: PagingData<SearchResult>) {
        val searchResult = pagingData.map { it.toMediaUiState() }
        _state.update {
            it.copy(
                searchResult = flow { searchResult },
                isLoading = false,
                isEmpty = false
            )
        }
//        Log.v("hassan", _state.value.searchResult..toString())
        viewModelScope.launch {
            _state.value.searchResult.collect{Log.v("hassan", "response is getting $it")}
        }
    }

    private fun onError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }

    fun onChangeCategory(type: SearchMedia) {
        _state.update { it.copy(selectedMediaType = type) }
    }

    /// region Search for All
//    private fun onSearchForAll() {
//        viewModelScope.launch {
//            getSearchResultUseCase(_state.value.inputText)
//                .map { pagingData ->
//                    pagingData.map {
//                        it.toSearchCardUiState()
//                    }  // Map each SearchResult to a SearchCardUiState
//                }
//                .map { cardUiStates ->  // Transform the PagingData<SearchCardUiState> to PagingData<SearchUiState>
//                    cardUiStates.toList().let {
//                        SearchUiState(
//                            searchResult = it,
//                            isLoading = false,
//                            isEmpty = it.isEmpty()
//                        )
//                    }
//                }
//                .distinctUntilChanged()
//                .cachedIn(viewModelScope)
//                .collect { pagingData ->
//                    _searchState.value = pagingData
//                }
//        }
////        tryToExecute(
////            function = { getSearchResultUseCase(_state.value.inputText) },
////            onSuccess = ::onGetSuccess,
////            onError = ::onGetError
////        )
//    }
//    private fun List<SearchResult>.toMediaUiState(): List<SearchUiState > {
//        return map { it.toMediaUiState() }
//    }
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