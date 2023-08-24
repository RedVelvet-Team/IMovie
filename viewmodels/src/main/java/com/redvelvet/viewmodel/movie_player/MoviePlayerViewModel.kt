package com.redvelvet.viewmodel.movie_player

import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MoviePlayerViewModel @Inject constructor() :
    BaseViewModel<MoviePlayerUiState, MovieDetailsUiEffect>(MoviePlayerUiState()) {
    init {
        getVideo()
    }
    fun getVideo(/*videoCode: String*/) {
        _state.update { it.copy(videoCode = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4") }
    }

    fun updateIsPlaying() {
        _state.update { it.copy(isPlaying = !it.isPlaying) }

    }

    fun updateTotalDuration(totalDuration: Long) {
        _state.update { it.copy(totalDuration = totalDuration) }
    }

    fun updateShouldShowControls(shouldShowControls:Boolean){
        _state.update { it.copy(shouldShowControls = shouldShowControls) }
    }

    fun updateCurrentTime(currentTime:Long){
        _state.update { it.copy(currentTime = currentTime) }
    }
    fun updateBufferedPercentage(bufferedPercentage:Int){
        _state.update { it.copy(bufferedPercentage = bufferedPercentage) }
    }
    fun updatePlaybackState(playbackState:Int){
        _state.update { it.copy(playbackState = playbackState) }
    }

}