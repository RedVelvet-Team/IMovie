package com.redvelvet.viewmodel.splash

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface SplashUiEffect : BaseUiEffect {
    data object NavigateToHome : SplashUiEffect
    data object NavigateToOnBoarding : SplashUiEffect
    data object NavigateToLogin : SplashUiEffect
}