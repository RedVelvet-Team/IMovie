package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class AuthenticationUserLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(userName: String, password: String) {
        authRepository.loginByAccount(userName, password)
    }

    suspend fun loginByGuest() {
        authRepository.loginByGuest()
    }
}