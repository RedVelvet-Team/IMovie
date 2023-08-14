package com.redvelvet.viewmodel.login


import com.redvelvet.usecase.usecase.auth.AuthenticationUserLoginUseCase
import com.redvelvet.usecase.usecase.auth.ValidationLoginUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationUserLoginUseCase: AuthenticationUserLoginUseCase,
    private val validation: ValidationLoginUseCase,
) : BaseViewModel<LoginUiState, LoginUiEffect>(LoginUiState()), LoginInteraction {

    //region guest
    private fun loginByGuest() {
        _state.update {
            it.copy(
                isLoading = true,
                error = null,
            )
        }
        tryToExecute(
            execute = authenticationUserLoginUseCase::loginByGuest,
            onSuccessWithoutData = ::onLoginByGuestSuccess,
            onError = ::onLoginByGuestFailed,
        )
    }

    private fun onLoginByGuestSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEffect(LoginUiEffect.NavigateTomHomeScreen)
    }

    private fun onLoginByGuestFailed(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = "error",
            )
        }
        sendUiEffect(LoginUiEffect.ShowToastError)
    }
    //endregion

    //region auth
    private fun loginByUserNameAndPassword(userName: String, password: String) {
        if (validation.invoke(userName, password)) {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null,
                )
            }
            tryToExecute(
                execute = { authenticationUserLoginUseCase.invoke(userName, password) },
                onSuccessWithoutData = ::onLoginNameAndPasswordSuccess,
                onError = ::onLoginByNameAndPasswordFailed,
            )
            return
        }
        updateInputErrorStatus()
    }

    private fun onLoginNameAndPasswordSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEffect(LoginUiEffect.NavigateTomHomeScreen)
    }

    private fun onLoginByNameAndPasswordFailed(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = "",
            )
        }
        sendUiEffect(LoginUiEffect.ShowToastError)
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

    private fun updateNameAndPasswordStatus() {
        updateInputNameError() && updateInputPasswordError().also { areEmpty ->
            takeIf { areEmpty }?._state?.update {
                it.copy(
                    isUserNameEmpty = true,
                    isPasswordEmpty = true,
                )
            }
        }
    }
    //endregion

    //region interaction
    override fun onClickLogin() {
        loginByUserNameAndPassword(state.value.userName, state.value.password)
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
        _state.update {
            it.copy(
                isPasswordVisible = !it.isPasswordVisible,
                error = null
            )
        }
    }

    override fun onClickForgotPassword() {
        sendUiEffect(LoginUiEffect.NavigateToForgotPassword)
    }
    //endregion
}