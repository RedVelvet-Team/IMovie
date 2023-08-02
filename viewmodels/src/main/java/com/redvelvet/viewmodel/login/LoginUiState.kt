package com.redvelvet.viewmodel.login

import com.redvelvet.viewmodel.base.BaseUiState


data class LoginUiState(
    val userName: String = "",
    val password: String = "",
    val userNameHelperText: String = "",
    val passwordHelperText: String = "",
    val isLoading: Boolean = false,
    val isValidForm: Boolean = false,
    val error: String? = null,
    val success: Boolean? = false,
) : BaseUiState