package com.redvelvet.viewmodel.youtube_player

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class YoutubePlayerViewModel @Inject constructor(savedStateHandle: SavedStateHandle) :
    BaseViewModel<YoutubePlayerUiState, Unit>(YoutubePlayerUiState()) {

    private val args: YoutubePlayerArgs = YoutubePlayerArgs(savedStateHandle)

    init {
        getVideo()
    }

    private fun getVideo() {
        _state.update {
            it.copy(videoCode = args.productionCode)
        }
    }
}