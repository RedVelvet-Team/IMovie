package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface OnBoardingUiEffect : BaseUiEffect {
    data object NavigateToLogin : OnBoardingUiEffect
    data object NavigateToSignUpScreen : OnBoardingUiEffect

}