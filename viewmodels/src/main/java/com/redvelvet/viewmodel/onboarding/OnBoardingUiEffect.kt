package com.redvelvet.viewmodel.onboarding

sealed interface OnBoardingUiEffect {
    data object NavigateToLoginScreen : OnBoardingUiEffect
    data object NavigateToSignUpScreen : OnBoardingUiEffect
    data object NavigateToHomeScreen : OnBoardingUiEffect

}