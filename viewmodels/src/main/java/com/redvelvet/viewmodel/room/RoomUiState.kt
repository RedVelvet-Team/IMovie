package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class RoomUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val isCreateRoomClicked: Boolean = false,
    val isJoinRoomClicked: Boolean = false,
    val isCreateRoomLonelyClicked: Boolean = false
) : BaseUiState
