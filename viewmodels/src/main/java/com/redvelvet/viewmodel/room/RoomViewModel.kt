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
) : BaseViewModel<RoomUiState, BaseUiEffect>(RoomUiState()){



    fun createRoom() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = createRoomUseCase::invoke,
            onSuccessWithoutData = ::onSuccess,
            onError = ::onError,
        )
    }

    fun joinRoom(id: String) {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = {joinRoomUseCase(id = id)},
            onSuccessWithoutData = ::onSuccess,
            onError = ::onError,
        )

    }

    private fun onSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        Log.d("Kamel","dfdsgvvgdfsgbfg")
    }

    private fun onError(e: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = e,
            )
        }
        Log.d("Kamel","a7a")
    }


}