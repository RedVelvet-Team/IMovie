package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor() : BaseViewModel<RoomUiState, RoomUiEffect>(RoomUiState()),
    RoomInteractions {

    init {
        onClickCreateRoom(state.value.dialogState.movieUrl)
        onClickJoinRoom(state.value.dialogState.roomUrl)
    }

    override fun onClickCreateRoom(newMovieUrl: String) {
        _state.update {
            it.copy(
                isCreateRoomClicked = true,
                dialogState = it.dialogState.copy(movieUrl = newMovieUrl, showDialog = true)
            )
        }
        sendUiEffect(RoomUiEffect.ShowDialogToCreateRoom)
    }

    override fun onClickJoinRoom(newRoomUrl: String) {
        _state.update {
            it.copy(
                isJoinRoomClicked = true,
                dialogState = it.dialogState.copy(roomUrl = newRoomUrl,showDialog = true)
            )
        }
        sendUiEffect(RoomUiEffect.ShowDialogToJoinRoom)
    }

    override fun onClickCreateRoomLonely() {
        _state.update { it.copy(isCreateRoomLonelyClicked = true) }
        sendUiEffect(RoomUiEffect.ShowDialogToCreateRoomLonely)
    }

   /* fun updateMovieUrl(newMovieUrl: String) {
        try {
            _state.update { it.copy(dialogState = it.dialogState.copy(movieUrl = newMovieUrl)) }
        } catch (message: Throwable) {
            onMovieUrlError()
        }
    }

    fun updateRoomUrl(newRoomUrl: String) {
        try {
            _state.update { it.copy(dialogState = it.dialogState.copy(roomUrl = newRoomUrl)) }
        } catch (message: Throwable) {
            onMovieUrlError()
        }
    }

    fun onMovieUrlError() {
        _state.update { it.copy(dialogState = it.dialogState.copy(isError = true)) }
    }*/

}