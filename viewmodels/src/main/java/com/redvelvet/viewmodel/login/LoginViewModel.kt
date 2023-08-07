package com.redvelvet.viewmodel.login


import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.usecase.usecase.auth.AuthenticationUserLoginUseCase
import com.redvelvet.usecase.usecase.auth.LoginByGuestUseCase
import com.redvelvet.usecase.usecase.auth.ValidationLoginUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.onboarding.OnBoardingUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationUserLoginUseCase: AuthenticationUserLoginUseCase,
    private val loginByGuestUseCase: LoginByGuestUseCase,
    private val validation: ValidationLoginUseCase,
) : BaseViewModel<LoginUiState, LoginUiEvent>(LoginUiState()), LoginInteraction {

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

    //region signup
    private fun signUp() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(LoginUiEvent.NavigateToSignUpScreen)
    }
    //endregion

    //region error input status
    private fun updateInputErrorStatus() {
        updateInputNameError()
        updateInputPasswordError()
        updateNameAndPasswordStatus()
    }

    private fun updateInputNameError(): Boolean {
        return state.value.userName.isEmpty().also { isEmpty ->
            takeIf { isEmpty }?._state?.update {
                it.copy(
                    isUserNameEmpty = true,
                    isPasswordEmpty = false,
                )
            }
        }
    }

    private fun updateInputPasswordError(): Boolean {
        return state.value.password.isEmpty().also { isEmpty ->
            takeIf { isEmpty }?._state?.update {
                it.copy(
                    isUserNameEmpty = false,
                    isPasswordEmpty = true,
                )
            }
        }
    }

    private fun updateNameAndPasswordStatus(): Boolean {
        return updateInputNameError() && updateInputPasswordError().also { areEmpty ->
            takeIf { areEmpty }?._state?.update {
                it.copy(
                    isUserNameEmpty = true,
                    isPasswordEmpty = true,
                )
            }
        }
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
        if (validation(state.value.userName, state.value.password)) {
            loginByUserNameAndPassword(state.value.userName, state.value.password)
            return
        }
        updateInputErrorStatus()
    }

    override fun onClickGuest() {
        loginByGuest()
    }


    override fun onUserNameChanged(userName: String) {
        _state.update {
            it.copy(
                userName = userName,
                isUserNameEmpty = false,
                isLoading = false,
                error = null
            )
        }
    }

    override fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
                isLoading = false,
                error = null,
                isPasswordEmpty = false
            )
        }
    }

    override fun onClickEyeIcon() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }
    //endregion
}