package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class ValidateUserWithLoginUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(userName: String, password: String) =
        userRepository.validateUserWithLogin(
            userName = userName,
            password = password,
        )
}