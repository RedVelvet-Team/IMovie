package com.redvelvet.viewmodel.movie_player

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.party.StreamMovieUseCase
import com.redvelvet.usecase.usecase.user.ManageUserDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviePlayerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val streamMovieUseCase: StreamMovieUseCase,
    private val manageUserDetailsUseCase: ManageUserDetailsUseCase,
) :
    BaseViewModel<MoviePlayerUiState, MovieDetailsUiEffect>(MoviePlayerUiState()) {

    private val moviePlayerArg = MoviePlayerArgs(savedStateHandle)

    init {
        getVideoLink()
        getRoomLink()
    }


    private fun getVideoLink() {
        viewModelScope.launch(Dispatchers.IO) {
            val currentUser = manageUserDetailsUseCase.invoke()
            streamMovieUseCase.invoke(moviePlayerArg.roomId).collect { movieParty ->
                if (currentUser == movieParty.adminName)
                    _state.update { it.copy(isAdmin = true) }
                else
                    _state.update { it.copy(isAdmin = false) }
                _state.update { it.copy(videoUrl = movieParty.movieLink) }
            }
        }
    }

    private fun getRoomLink() {
        _state.update { it.copy(roomLink = "") }
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