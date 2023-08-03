package com.redvelvet.viewmodel.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.error.ErrorType
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<MovieDetailsScreenUiState> =
        MutableStateFlow(MovieDetailsScreenUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        _state.update { MovieDetailsScreenUiState(isLoading = true, isError = Pair(false, "")) }
        viewModelScope.launch {
            try {
                _state.update {
                    MovieDetailsScreenUiState(
                        data = getMovieFullDetailsUseCase(298618).toMovieFullDetailsScreenUiState(),
                        isLoading = false
                    )
                }
            } catch (e: ErrorType) {
                _state.update {
                    MovieDetailsScreenUiState(
                        data = null,
                        isLoading = false,
                        isError = Pair(true, e.message.toString())
                    )
                }
            }
        }
    }
}