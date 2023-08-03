package com.redvelvet.viewmodel.login


import com.redvelvet.entities.auth.Guest
import com.redvelvet.usecase.usecase.auth.AuthenticationUserLoginUseCase
import com.redvelvet.usecase.usecase.auth.LoginByGuestUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginByGuestUseCase: LoginByGuestUseCase,
    private val authenticationUserLoginUseCase: AuthenticationUserLoginUseCase,
) : BaseViewModel<LoginUiState, LoginUiEvent>(LoginUiState()), LoginInteraction {

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
        sendUiEvent(LoginUiEvent.NavigateTomHomeScreen)
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


    //region interaction
    override fun onClickLogin() {

    }

    override fun onClickGuest() {
        if (state.value.userName.isEmpty() || state.value.password.isEmpty())
            _state.update {
                it.copy(
                    isPasswordEmpty = true,
                    isUserNameEmpty = true,
                )
            }
        else {
            _state.update {
                it.copy(
                    isPasswordEmpty = false,
                    isUserNameEmpty = false,
                )
            }
            loginByGuest()
        }

    }

    override fun onClickSignUp() {

    }

    override fun onUserNameChanged(userName: String) {
        _state.update {
            it.copy(
                userName = userName,
            )
        }
    }

    override fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
            )
        }
    }
    //endregion
}