package com.redvelvet.viewmodel.onboarding

sealed interface OnBoardingUiEvent {
    data object NavigateToLogin: OnBoardingUiEvent
}