package com.redvelvet.viewmodel.room

import android.util.Log
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor() : BaseViewModel<RoomUiState, RoomUiEffect>(RoomUiState()),
    RoomInteractions {

    override fun onClickCreateRoom() {
        _state.update {
            it.copy(
                isCreateRoomClicked = true,
                buttonClicked=Clicked.CREATE,
                dialogState = it.dialogState.copy(showDialog = true)
            )
        }
        sendUiEffect(RoomUiEffect.ShowDialogToCreateRoom)
        Log.e("test", "onClickCreateRoom${ state.value.dialogState.showDialog}")

    }

    override fun onClickJoinRoom() {
        _state.update {
            it.copy(
                isJoinRoomClicked = true,
                buttonClicked=Clicked.JOIN,
                dialogState = it.dialogState.copy(showDialog = true)
            )
        }
        sendUiEffect(RoomUiEffect.ShowDialogToJoinRoom)
        Log.e("test","onClickJoinRoom ${state.value.dialogState.showDialog}")
    }

    override fun onClickSubmit() {
        sendUiEffect(RoomUiEffect.NavigateToVideoPlayer)
    }

    override fun onClickCancel() {
        _state.update {
            it.copy(
                buttonClicked=Clicked.None,
                dialogState = it.dialogState.copy(showDialog = false
                )
            )
        }
        Log.e("test","onClickCancel${state.value.dialogState.showDialog}")

    }

     fun updateMovieUrl(newMovieUrl: String) {
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
     }

}