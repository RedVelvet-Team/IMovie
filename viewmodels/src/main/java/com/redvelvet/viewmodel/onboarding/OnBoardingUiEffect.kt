package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface OnBoardingUiEffect : BaseUiEffect {
    data object NavigateToLoginScreen : OnBoardingUiEffect
    data object NavigateToSignUpScreen : OnBoardingUiEffect
    data object NavigateToHomeScreen : OnBoardingUiEffect

}