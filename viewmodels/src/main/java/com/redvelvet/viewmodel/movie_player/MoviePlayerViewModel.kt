package com.redvelvet.viewmodel.movie_player

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.party.StreamMovieUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviePlayerViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle,
    private val streamMovieUseCase: StreamMovieUseCase,
) :
    BaseViewModel<MoviePlayerUiState, MovieDetailsUiEffect>(MoviePlayerUiState()) {

    val moviePlayerArg = MoviePlayerArgs(savedStateHandle)

    init {
        getVideoLink()
        getRoomLink()
    }


    private fun getVideoLink() {
        viewModelScope.launch {
            streamMovieUseCase.invoke("1693378945056").collect{ movieParty ->
                _state.update { it.copy(videoUrl = movieParty.movieLink) }
                Log.d("Kamel",_state.value.toString())
            }
        }
    }

    private fun getRoomLink() {
        _state.update { it.copy(roomLink = " ") }
    }

    fun updateIsPlaying() {
        _state.update { it.copy(isPlaying = !it.isPlaying) }

    }

    fun updateTotalDuration(totalDuration: Long) {
        _state.update { it.copy(totalDuration = totalDuration) }
    }

    fun updateShouldShowControls(shouldShowControls: Boolean) {
        _state.update { it.copy(shouldShowControls = shouldShowControls) }
    }

    fun updateCurrentTime(currentTime: Long) {
        _state.update { it.copy(currentTime = currentTime) }
    }

    fun updateBufferedPercentage(bufferedPercentage: Int) {
        _state.update { it.copy(bufferedPercentage = bufferedPercentage) }
    }

    fun updatePlaybackState(playbackState: Int) {
        _state.update { it.copy(playbackState = playbackState) }
    }


}