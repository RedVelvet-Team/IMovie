package com.redvelvet.usecase.usecase.auth

import com.redvelvet.entities.user.AccountDetails
import com.redvelvet.usecase.repository.AuthRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import javax.inject.Inject


class GetAccountDetailsUsecase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
    private val checkUserLoggedInUseCase: CheckUserLoggedInUseCase,
) {
    suspend operator fun invoke(): Boolean {
        if (!checkUserLoggedInUseCase.isLoggedInByAccount()) {
            return false
        }
        getAccountDetailsIfUserIsLoggedIn()
        return true
    }

    private suspend fun getAccountDetailsIfUserIsLoggedIn(): AccountDetails {
        return authRepository.getAccountDetails(sessionId = userRepository.getUserSessionIdFromLocal())
    }
}

