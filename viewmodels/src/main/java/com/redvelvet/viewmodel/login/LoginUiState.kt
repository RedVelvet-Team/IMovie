package com.redvelvet.viewmodel.login

import com.redvelvet.viewmodel.base.BaseUiState


data class LoginUiState(
    val userName: String = "",
    val password: String = "",
    val isUserNameEmpty: Boolean = false,
    val isPasswordEmpty: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
) : BaseUiState