package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiEvent

sealed interface OnBoardingUiEvent : BaseUiEvent {
    data object NavigateToLogin : OnBoardingUiEvent
    data object NavigateToSignUpScreen : OnBoardingUiEvent

}