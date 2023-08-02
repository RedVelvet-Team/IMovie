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
) : BaseViewModel<LoginUiState, LoginUiEvent>(LoginUiState()) {
    fun loginByGuest() {
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

    fun onUserNameChanged(userName: String) {
        val isValidUserName = true
        _state.update {
            it.copy(
                userName = userName,
                userNameHelperText = if (isValidUserName) "" else "Invalid username.",
                isValidForm = isValidUserName && _state.value.password.isNotEmpty()
            )
        }
    }

    fun onPasswordChanged(password: String) {
        val isValidPassword = true
        _state.update {
            it.copy(
                password = password,
                passwordHelperText = if (isValidPassword) "" else "Invalid password",
                isValidForm = isValidPassword && _state.value.userName.isNotEmpty()
            )
        }
    }
}