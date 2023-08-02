package com.redvelvet.viewmodel.login


import android.util.Log
import com.redvelvet.usecase.usecase.auth.CreateGuestSessionUseCase
import com.redvelvet.usecase.usecase.auth.CreateTokenUseCase
import com.redvelvet.usecase.usecase.auth.CreateUserSessionUseCase
import com.redvelvet.usecase.usecase.auth.ValidateUserWithLoginUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val createGuestSessionUseCase: CreateGuestSessionUseCase,
    private val createTokenUseCase: CreateTokenUseCase,
    private val validateUserWithLoginUseCase: ValidateUserWithLoginUseCase,
    private val createUserSessionUseCase: CreateUserSessionUseCase,
) : BaseViewModel<LoginUiState>(LoginUiState()) {
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

    fun createSession() {
        createRequestToken()
        val userName = _state.value.userName
        val password = _state.value.password
        validateUserWithLogin(userName, password)
        tryToExecute(
            execute = {
                _state.update { it.copy(isLoading = true, error = null) }
                createUserSessionUseCase()
            },
            onSuccess = {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                    )
                }
            },
            onError = { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
            },
        )
    }

    private fun validateUserWithLogin(userName: String, password: String) {
        tryToExecute(
            execute = {
                _state.update {
                    it.copy(
                        isLoading = true,
                        error = null,
                    )
                }
                validateUserWithLoginUseCase(userName, password)
            },
            onSuccess = {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                    )
                }
            },
            onError = { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
            },
        )
    }

    private fun createRequestToken() {
        tryToExecute(
            execute = {
                _state.update {
                    it.copy(
                        isLoading = true,
                        error = null,
                    )
                }
                createTokenUseCase()
            },
            onSuccess = {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                    )
                }
            },
            onError = { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = error.message
                    )
                }
            },
        )
    }

    fun createGuestSession() {
        tryToExecute(
            execute = {
                _state.update {
                    it.copy(
                        isLoading = true,
                        error = null,
                        success = false,
                    )
                }
                val response = createGuestSessionUseCase()
                Log.i("KAMELOO", response.toString())
            },
            onSuccess = {
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                        success = true,
                    )
                }
            },
            onError = { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = error.message,
                        success = false,
                    )
                }
            },
        )
    }
}