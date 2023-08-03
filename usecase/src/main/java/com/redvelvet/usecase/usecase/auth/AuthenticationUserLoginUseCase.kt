package com.redvelvet.usecase.usecase.auth

import com.redvelvet.entities.auth.Session
import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class AuthenticationUserLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(userName: String, password: String): Session {
        val token = createToken()
        validateTokenWithUserNameAndPassword(
            userName = userName,
            password = password,
            requestToken = token.requestToken.toString()
        )
        return authRepository.createUserSession(token = token.requestToken.toString())
    }

    private suspend fun createToken() = authRepository.createToken()

    private suspend fun validateTokenWithUserNameAndPassword(
        userName: String,
        password: String,
        requestToken: String,
    ) {
        authRepository.validateUserWithLogin(
            userName = userName,
            password = password,
            requestToken = requestToken,
        )
    }

}