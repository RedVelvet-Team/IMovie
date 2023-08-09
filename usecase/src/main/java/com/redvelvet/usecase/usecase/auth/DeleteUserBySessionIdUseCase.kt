package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class DeleteUserBySessionIdUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke() =
        authRepository.deleteUserSession(userRepository.getUserSessionId())
}