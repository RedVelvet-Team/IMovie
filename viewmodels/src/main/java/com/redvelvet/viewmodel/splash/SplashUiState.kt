package com.redvelvet.viewmodel.splash

import com.redvelvet.viewmodel.base.BaseUiState


data class SplashUiState(
    val isLogged: Boolean = false,
    val isGuest: Boolean = false,
    val isFirstTimeUseApp: Boolean = false,
) : BaseUiState
