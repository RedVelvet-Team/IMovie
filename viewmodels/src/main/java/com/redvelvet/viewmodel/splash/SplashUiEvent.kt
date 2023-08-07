package com.redvelvet.viewmodel.splash

import com.redvelvet.viewmodel.base.BaseUiEvent

sealed interface SplashUiEvent : BaseUiEvent {
    data object NavigateToHome : SplashUiEvent
    data object NavigateToOnBoarding : SplashUiEvent
    data object NavigateToLogin : SplashUiEvent
}