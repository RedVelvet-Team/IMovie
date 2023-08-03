package com.redvelvet.viewmodel.splash

import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.user.CheckUserFirstTimeUseAppUseCase
import com.redvelvet.usecase.usecase.user.CheckUserIsGuestUseCase
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkUserFirstTimeUseAppUseCase: CheckUserFirstTimeUseAppUseCase,
    private val checkUserUserIsLoggedInUseCase: CheckUserLoggedInUseCase,
    private val checkUserIsGuestUseCase: CheckUserIsGuestUseCase
) : BaseViewModel<SplashUiState, SplashUiEvent>(SplashUiState()) {
    init {
        prepareUserStatus()
    }

    private fun prepareUserStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            val isLogged = checkUserUserIsLoggedInUseCase()
            val isGuest = checkUserIsGuestUseCase()
            val isFirstTimeUseApp = checkUserFirstTimeUseAppUseCase()
            delay(1000)
            _state.update {
                it.copy(
                    isLogged = isLogged,
                    isGuest = isGuest,
                    isFirstTimeUseApp = isFirstTimeUseApp
                )
            }
            state.value
            checkUserStatus()
        }
    }

    //region check user status
    private fun checkUserStatus() {
        checkUserFirstTimeUseApp()
        checkUserIsLoggedIn()
    }

    private fun checkUserFirstTimeUseApp() {
        takeIf {
            state.value.isFirstTimeUseApp
        }?.sendUiEvent(SplashUiEvent.NavigateToOnBoarding)
    }

    private fun checkUserIsLoggedIn() {
        takeIf {
            state.value.isLogged || state.value.isGuest
        }?.sendUiEvent(SplashUiEvent.NavigateToHome) ?: sendUiEvent(SplashUiEvent.NavigateToLogin)
    }
    //endregion
}