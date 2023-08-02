package com.redvelvet.viewmodel.login

sealed interface LoginUiEvent {
    data object NavigateTomHomeScreen : LoginUiEvent
}