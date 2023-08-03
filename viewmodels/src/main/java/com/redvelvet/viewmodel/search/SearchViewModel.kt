package com.redvelvet.viewmodel.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.search.GetMoviesSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetPeopleSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetTvShowsSearchResultUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMoviesSearchResultUseCase: GetMoviesSearchResultUseCase,
    private val getPeopleSearchResultUseCase: GetPeopleSearchResultUseCase,
    private val getSearchResultUseCase: GetSearchResultUseCase,
    private val getTvShowsSearchResultUseCase: GetTvShowsSearchResultUseCase,
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
            function = {
                getSearchResultUseCase(_state.value.inputText ?: "")
                    .map { it.toMediaUiState() }
            },
            onSuccess = ::onGetAllSuccess,
            onError = ::onGetError
        )
    }
    private fun onGetAllSuccess(result: List<SearchCardUiState>) {
        _state.update { it.copy(searchResult = result, selectedMediaType = SearchMedia.ALL) }
        Log.v("hassan", state.value.toString())
    }

    /// endregion

    /// region Search for movie
    private fun onSearchForMovie() {
        tryToExecute(
            function = {
                getMoviesSearchResultUseCase(_state.value.inputText ?: "")
                    .map {
                        it.toMediaUiState()
                    }
            },
            onSuccess = ::onGetMovieSuccess,
            onError = ::onGetError
        )
    }

    private fun onGetMovieSuccess(result: List<SearchCardUiState>) {
        _state.update { it.copy(searchResult = result, selectedMediaType = SearchMedia.MOVIE) }
    }

    /// endregion

    /// region Search for TvShow
    private fun onSearchForTvShow() {
        tryToExecute(
            function = {
                getTvShowsSearchResultUseCase(_state.value.inputText ?: "")
                    .map { it.toMediaUiState() }
            },
            onSuccess = ::onGetTvSuccess,
            onError = ::onGetError
        )
    }

    private fun onGetTvSuccess(result: List<SearchCardUiState>) {
        _state.update { it.copy(searchResult = result, selectedMediaType = SearchMedia.TV) }
    }

    /// endregion

    /// region Search for Person
    private fun onSearchForPerson() {
        tryToExecute(
            function = {
                getPeopleSearchResultUseCase(_state.value.inputText ?: "")
                    .map { it.toMediaUiState() }
            },
            onSuccess = ::onGetPersonSuccess,
            onError = ::onGetError
        )
    }

    private fun onGetPersonSuccess(result: List<SearchCardUiState>) {
        _state.update { it.copy(searchResult = result, selectedMediaType = SearchMedia.PEOPLE) }
    }

    /// endregion
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