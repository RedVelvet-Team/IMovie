package com.redvelvet.viewmodel.login


import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : BaseViewModel<LoginUiState, LoginUiEvent>(LoginUiState()) {
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