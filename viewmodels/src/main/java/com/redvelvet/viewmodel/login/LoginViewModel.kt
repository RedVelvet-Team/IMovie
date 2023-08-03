package com.redvelvet.viewmodel.login


import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
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

    //region auth
    private fun loginByUserNameAndPassword(userName: String, password: String) {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = { authenticationUserLoginUseCase.invoke(userName, password) },
            onSuccess = ::onLoginNameAndPasswordSuccess,
            onError = ::onLoginByNameAndPasswordFailed,
        )
    }

    private fun onLoginNameAndPasswordSuccess(session: Session) {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(LoginUiEvent.NavigateTomHomeScreen)
    }

    private fun onLoginByNameAndPasswordFailed(error: ErrorUiState) {
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
        if (state.value.userName.isEmpty())
            _state.update {
                it.copy(
                    isUserNameEmpty = true,
                )
            }
        else if (state.value.password.isEmpty()) {
            _state.update {
                it.copy(
                    isPasswordEmpty = true,
                )
            }
        } else if (state.value.password.isEmpty() && state.value.userName.isEmpty()) {
            _state.update {
                it.copy(
                    isPasswordEmpty = true,
                    isUserNameEmpty = true,
                )
            }
        } else {
            loginByUserNameAndPassword(state.value.userName, state.value.password)
        }
    }

    override fun onClickGuest() {
        loginByGuest()
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