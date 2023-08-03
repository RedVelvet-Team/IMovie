package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class ValidateUserWithUserNameAndPasswordUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        userName: String,
        password: String,
        requestToken: String
    ) =
        authRepository.validateUserWithLogin(
            userName = userName,
            password = password,
            requestToken = requestToken,
        )
}