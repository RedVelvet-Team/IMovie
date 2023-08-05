package com.redvelvet.usecase.usecase.auth

import javax.inject.Inject

class ValidationLoginUseCase @Inject constructor() {
    operator fun invoke(userName: String, password: String): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }
}