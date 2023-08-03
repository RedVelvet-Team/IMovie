package com.redvelvet.viewmodel.splash

sealed interface SplashUiEvent {
    data object NavigateToHome : SplashUiEvent
    data object NavigateToOnBoarding : SplashUiEvent
}