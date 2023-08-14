package com.redvelvet.viewmodel.onboarding

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class OnBoardingUiState(
    val loggedIn: Boolean = false,
    val error: ErrorUiState? = null,
) : BaseUiState
