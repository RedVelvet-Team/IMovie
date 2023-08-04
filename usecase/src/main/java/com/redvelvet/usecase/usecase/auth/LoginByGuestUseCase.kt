package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class LoginByGuestUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() = authRepository.createGuestSession()
}