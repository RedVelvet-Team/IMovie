package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiState


data class OnBoardingUiState(
    val saved: Boolean = false,
) : BaseUiState
