package com.redvelvet.viewmodel.movie_player

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MoviePlayerViewModel @Inject constructor(
    val savedStateHandle: SavedStateHandle
) :
    BaseViewModel<MoviePlayerUiState, MovieDetailsUiEffect>(MoviePlayerUiState()) {

    val moviePlayerArg = MoviePlayerArgs(savedStateHandle)

    init {
        getVideo()
    }

    fun getVideo() {
        _state.update { it.copy(videoUrl = moviePlayerArg.videoUrl) }
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