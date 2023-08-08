package com.redvelvet.viewmodel.login

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface LoginUiEffect : BaseUiEffect {
    data object NavigateTomHomeScreen : LoginUiEffect
    data object NavigateToSignUpScreen : LoginUiEffect

}