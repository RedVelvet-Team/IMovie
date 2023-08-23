package com.redvelvet.viewmodel.youtube_player

import com.redvelvet.viewmodel.base.BaseUiState

data class YoutubePlayerUiState(
    val videoCode: String = "",
    val isPlayerLoading :Boolean = true
):BaseUiState