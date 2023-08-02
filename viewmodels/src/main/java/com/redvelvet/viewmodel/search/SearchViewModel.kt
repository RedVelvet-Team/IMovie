package com.redvelvet.viewmodel.search

import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.search.GetMoviesSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetPeopleSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetSearchResultUseCase
import com.redvelvet.usecase.usecase.search.GetTvShowsSearchResultUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
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

//    val query = MutableStateFlow("")
//
//    init {
//        viewModelScope.launch {
//            query.onEach {
//                _state.update { it.copy(isLoading = true) }
//            }.debounce(500)
//                .collect { onChangeSearchTextFiled(it) }
//        }
//    }

    fun onChangeSearchTextFiled(query: String) {
        _state.update { it.copy(inputText = query, isLoading = true) }
        viewModelScope.launch {
            when (_state.value.mediaType) {
                SearchMedia.MOVIE -> onSearchForMovie()
                SearchMedia.PEOPLE -> onSearchForPerson()
                SearchMedia.TV -> onSearchForTvShow()
                SearchMedia.ALL -> onSearchForAll()
            }
        }
    }

    private fun onSearchForMovie() {
        tryToExecute(
            function = {
                getMoviesSearchResultUseCase(
                    _state.value.inputText ?: ""
                ).map { it.toMediaUiState() }
            },
            onSuccess = ::onGetMovieSuccess,
            onError = ::onGetError
        )
    }

    private fun onSearchForPerson() {
        tryToExecute(
            function = {
                getPeopleSearchResultUseCase(
                    _state.value.inputText ?: ""
                ).map { it.toMediaUiState() }
            },
            onSuccess = ::onGetPersonSuccess,
            onError = ::onGetError
        )
    }

    private fun onSearchForTvShow() {
        tryToExecute(
            function = {
                getTvShowsSearchResultUseCase(
                    _state.value.inputText ?: ""
                ).map { it.toMediaUiState() }
            },
            onSuccess = ::onGetTvSuccess,
            onError = ::onGetError
        )
    }

    private fun onSearchForAll() {
        tryToExecute(
            function = {
                getSearchResultUseCase(
                    _state.value.inputText ?: ""
                ).map { it.toMediaUiState() }
            },
            onSuccess = ::onGetAllSuccess,
            onError = ::onGetError
        )
    }

    private fun onGetMovieSuccess(result: List<MediaUiState>) {
        _state.update { it.copy(searchResult = result, mediaType = SearchMedia.MOVIE) }
    }

    private fun onGetPersonSuccess(result: List<MediaUiState>) {
        _state.update { it.copy(searchResult = result, mediaType = SearchMedia.PEOPLE) }
    }

    private fun onGetTvSuccess(result: List<MediaUiState>) {
        _state.update { it.copy(searchResult = result, mediaType = SearchMedia.TV) }
    }

    private fun onGetAllSuccess(result: List<MediaUiState>) {
        _state.update { it.copy(searchResult = result, mediaType = SearchMedia.ALL) }
    }


    private fun onGetError(error: ErrorUiState) {
        _state.update { it.copy(error = error) }
    }

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
}