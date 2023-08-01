package com.redvelvet.viewmodel.login


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel(){
     private val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
     val state: StateFlow<LoginUiState> = _state.asStateFlow()

     fun onUserNameChanged(userName: String) {
          val isValidUserName = true
          _state.value = _state.value.copy(
               userName = userName,
               userNameHelperText = if (isValidUserName) "" else "Invalid username.",
               isValidForm = isValidUserName && _state.value.password.isNotEmpty()
          )
     }

     fun onPasswordChanged(password: String) {
          val isValidPassword = true
          _state.value = _state.value.copy(
               password = password,
               passwordHelperText = if (isValidPassword) "" else "Invalid password. Password should have at least 6 characters.",
               isValidForm = isValidPassword && _state.value.userName.isNotEmpty()
          )
     }

     fun onLoginClicked() {
          val userName = _state.value.userName
          val password = _state.value.password
     }

     fun onGuestClicked() {

     }
}