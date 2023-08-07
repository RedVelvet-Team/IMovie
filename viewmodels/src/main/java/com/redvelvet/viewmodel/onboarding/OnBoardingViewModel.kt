package com.redvelvet.viewmodel.onboarding

import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.auth.Guest
import com.redvelvet.usecase.usecase.auth.LoginByGuestUseCase
import com.redvelvet.usecase.usecase.user.SetUserNotFirstTimeUseAppUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setUserNotFirstTimeUseApp: SetUserNotFirstTimeUseAppUseCase,
    private val loginByGuestUseCase: LoginByGuestUseCase,

    ) : BaseViewModel<OnBoardingUiState, OnBoardingUiEvent>(OnBoardingUiState()),
    OnBoardingInteractions {

    fun setNotFirstTimeUseApp() {
        viewModelScope.launch(Dispatchers.IO) {
            setUserNotFirstTimeUseApp.invoke()
            _state.update {
                it.copy(
                    saved = true,
                )
            }
            sendUiEvent(OnBoardingUiEvent.NavigateToLogin)
        }
    }

    //region sign in
    private fun signIn() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(OnBoardingUiEvent.NavigateToLogin)
    }

    //endregion

    //region signup
    private fun signUp() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(OnBoardingUiEvent.NavigateToSignUpScreen)
    }

    //endregion

    //region guest
    private fun loginByGuest() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = loginByGuestUseCase::invoke,
            onSuccess = ::onLoginByGuestSuccess,
            onError = ::onLoginByGuestFailed,
        )
    }
    private fun onLoginByGuestSuccess(guest: Guest) {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(OnBoardingUiEvent.NavigateTomHomeScreen)
    }
    private fun onLoginByGuestFailed(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error.message,
            )
        }
    }
    //endregion
    override fun onClickLogin() {
        signIn()
    }
    override fun onClickGuest() {
        loginByGuest()
    }
    override fun onClickSignUp() {
        signUp()
    }
}