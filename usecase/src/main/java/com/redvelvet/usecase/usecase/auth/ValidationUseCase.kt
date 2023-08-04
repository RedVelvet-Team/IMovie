package com.redvelvet.usecase.usecase.auth

import javax.inject.Inject

class ValidationUseCase @Inject constructor() {
    operator fun invoke(userName: String, password: String): Boolean {
        return (nameAndPasswordAreEmpty(
            userName,
            password
        ) || nameIsEmpty(userName) || passwordIsEmpty(password))
            .not()
    }

    fun nameIsEmpty(userName: String): Boolean {
        return userName.isEmpty()
    }

    fun passwordIsEmpty(password: String): Boolean {
        return password.isEmpty()
    }

    fun nameAndPasswordAreEmpty(userName: String, password: String): Boolean {
        return nameIsEmpty(userName) && passwordIsEmpty(password)
    }
}