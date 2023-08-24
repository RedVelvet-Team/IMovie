package com.redvelvet.viewmodel.room

import com.redvelvet.usecase.usecase.CreateRoomUseCase
import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val createRoomUseCase: CreateRoomUseCase,
) : BaseViewModel<RoomUiState, BaseUiEffect>(RoomUiState()) {

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

    private fun onSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onError(e: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = e,
            )
        }
    }
}