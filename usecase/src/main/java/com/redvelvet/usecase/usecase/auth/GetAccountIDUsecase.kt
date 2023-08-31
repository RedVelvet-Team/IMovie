package com.redvelvet.usecase.usecase.auth

import com.redvelvet.entities.user.AccountDetails
import com.redvelvet.usecase.repository.AuthRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject


class GetAccountIDUsecase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): AccountDetails {
        return authRepository.getAccountDetails(sessionId = userRepository.getUserSessionIdFromLocal())
    }
}

