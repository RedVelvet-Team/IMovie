package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class RoomUiEffect : BaseUiEffect {
    data object ShowDialogToJoinRoom : RoomUiEffect()
    data class NavigateToVideoPlayer(val roomUrl: String) : RoomUiEffect()
}