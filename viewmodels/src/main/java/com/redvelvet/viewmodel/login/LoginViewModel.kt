package com.redvelvet.viewmodel.login


import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.usecase.usecase.auth.AuthenticationUserLoginUseCase
import com.redvelvet.usecase.usecase.auth.LoginByGuestUseCase
import com.redvelvet.usecase.usecase.auth.ValidationLoginUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authenticationUserLoginUseCase: AuthenticationUserLoginUseCase,
    private val loginByGuestUseCase: LoginByGuestUseCase,
    private val validation: ValidationLoginUseCase,
) : BaseViewModel<LoginUiState, LoginUiEffect>(LoginUiState()), LoginInteraction {

    //region guest
    private fun loginByGuest() {
        _state.update {
            it.copy(
                isLoading = true,
                isError = null,
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
                isError = null,
            )
        }
        sendUiEffect(LoginUiEffect.NavigateTomHomeScreen)
    }

    private fun onLoginByGuestFailed(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = null,
            )
        }
    }
    //endregion

    //region auth
    private fun loginByUserNameAndPassword(userName: String, password: String) {
        _state.update {
            it.copy(
                isLoading = true,
                isError = null,
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
                isError = null,
            )
        }
        sendUiEffect(LoginUiEffect.NavigateTomHomeScreen)
    }

    private fun onLoginByNameAndPasswordFailed(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = "",
            )
        }
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

    //region interaction
    override fun interactionLoginButtonClick() {
        if (validation(state.value.userName, state.value.password)) {
            loginByUserNameAndPassword(state.value.userName, state.value.password)
            return
        }
        updateInputErrorStatus()
    }

    override fun interactionGuestButtonClick() {
        loginByGuest()
    }


    override fun onUserNameChanged(userName: String) {
        _state.update {
            it.copy(
                userName = userName,
                isUserNameEmpty = false,
                isLoading = false,
                isError = null
            )
        }
    }

    override fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
                isLoading = false,
                isError = null,
                isPasswordEmpty = false
            )
        }
    }

    override fun interactionEyeIconClick() {
        _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }
    //endregion
}