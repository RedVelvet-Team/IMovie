package com.redvelvet.viewmodel.room

import android.util.Log
import com.redvelvet.usecase.usecase.party.CreateRoomUseCase
import com.redvelvet.usecase.usecase.party.JoinRoomUseCase
import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val createRoomUseCase: CreateRoomUseCase,
    private val joinRoomUseCase: JoinRoomUseCase,
) : BaseViewModel<RoomUiState, RoomUiEffect>(RoomUiState()), RoomInteractions {

    private fun createRoom() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = createRoomUseCase::invoke,
            onSuccessWithData = ::onCreateRoomSucceed,
            onError = ::onError,
        )
    }

    private fun onCreateRoomSucceed(partyId: String) {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
                dialogState = RoomUiState.DialogUiState().copy(
                    roomUrl = partyId
                )
            )
        }
        sendUiEffect(RoomUiEffect.NavigateToVideoPlayer(state.value.dialogState.roomUrl))
    }

    private fun joinRoom(id: String) {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = { joinRoomUseCase(id = id) },
            onSuccessWithoutData = ::onSuccess,
            onError = ::onError,
        )

    }

    private fun onSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
                isJoinRoomClicked = false,
                dialogState = it.dialogState.copy(showDialog = false)
            )
        }
        sendUiEffect(RoomUiEffect.NavigateToVideoPlayer(state.value.dialogState.roomUrl))
    }

    private fun onError(e: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = e,
            )
        }
        Log.e("KAMEL", e.message)
    }

    override fun onClickCreateRoom() {
        createRoom()
    }

    override fun onClickJoinRoom() {
        _state.update {
            it.copy(
                isJoinRoomClicked = true,
                dialogState = it.dialogState.copy(showDialog = true, roomUrl = ""),
            )
        }
        sendUiEffect(RoomUiEffect.ShowDialogToJoinRoom)
    }

    override fun onClickSubmit() {
        joinRoom(state.value.dialogState.roomUrl)
    }

    override fun onClickCancel() {
        _state.update {
            it.copy(
                buttonClicked = Clicked.None,
                dialogState = it.dialogState.copy(
                    showDialog = false
                )
            )
        }
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