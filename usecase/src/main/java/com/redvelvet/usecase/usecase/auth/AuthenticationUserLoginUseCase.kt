package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class AuthenticationUserLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(userName: String, password: String) {
        createToken()
        validateTokenWithUserNameAndPassword(userName = userName, password = password)
        authRepository.createUserSession(authRepository.getToken())
    }

    private suspend fun createToken() = authRepository.createToken()

    private suspend fun validateTokenWithUserNameAndPassword(
        userName: String,
        password: String,
    ) {
        authRepository.validateUserWithLogin(
            userName = userName,
            password = password,
            token = authRepository.getToken(),
        )
    }

}