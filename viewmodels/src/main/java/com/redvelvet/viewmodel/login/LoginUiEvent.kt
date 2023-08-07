package com.redvelvet.viewmodel.login

import com.redvelvet.viewmodel.base.BaseUiEvent

sealed interface LoginUiEvent : BaseUiEvent {
    data object NavigateTomHomeScreen : LoginUiEvent
    data object NavigateToSignUpScreen : LoginUiEvent

}