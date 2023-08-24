package com.redvelvet.viewmodel.movie_player

import com.redvelvet.viewmodel.base.BaseUiState

data class MoviePlayerUiState(
    val videoCode: String = "https://example.com/myvideo.mp4",
    val shouldShowControls: Boolean = true,
    val isPlaying: Boolean = true,
    val totalDuration: Long = 0L,
    val currentTime: Long = 0L,
    val bufferedPercentage: Int = 0,
    val playbackState: Int = 0,
    val playerSeekBackIncrement: Long = 5 * 1000L,
    val playerSeekForwardIncrement: Long = 5 * 1000L,
):BaseUiState