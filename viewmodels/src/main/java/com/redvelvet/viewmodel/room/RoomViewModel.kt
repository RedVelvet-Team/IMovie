package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor()
    : BaseViewModel<RoomUiState, RoomUiEffect>(RoomUiState()),RoomInteractions {
    override fun onClickCreateRoom() {
        _state.update { it.copy(isCreateRoomClicked=true) }
        sendUiEffect(RoomUiEffect.ShowDialogToCreateRoom)
    }

    override fun onClickJoinRoom() {
        _state.update { it.copy(isJoinRoomClicked=true) }
        sendUiEffect(RoomUiEffect.ShowDialogToJoinRoom)
    }

    override fun onClickCreateRoomLonely() {
        _state.update { it.copy(isCreateRoomLonelyClicked=true) }
        sendUiEffect(RoomUiEffect.ShowDialogToCreateRoomLonely)
    }

}