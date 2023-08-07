package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiState


data class OnBoardingUiState(
    val saved: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    ) : BaseUiState
