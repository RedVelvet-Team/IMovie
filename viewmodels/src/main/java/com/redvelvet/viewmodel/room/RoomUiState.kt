package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class RoomUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val isCreateRoomClicked: Boolean = false,
    val isJoinRoomClicked: Boolean = false,
    val buttonClicked:Clicked=Clicked.None,
    val dialogState: DialogUiState = DialogUiState()
) : BaseUiState {
    data class DialogUiState(
        val movieUrl: String = "",
        val roomUrl: String = "",
        val showDialog: Boolean = false,
        val isError: Boolean = false,
    )
}
enum class Clicked{JOIN,CREATE,None}

