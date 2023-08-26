package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class  RoomUiEffect: BaseUiEffect {

    data object ShowDialogToCreateRoom : RoomUiEffect()
    data object ShowDialogToJoinRoom : RoomUiEffect()
    data object ShowDialogToCreateRoomLonely : RoomUiEffect()
    data object NavigateToVideoPlayer : RoomUiEffect()

}