package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CheckUserLoggedInUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Boolean {
        return isLoggedInByGuest() || isLoggedInByAccount()
    }

    suspend fun isLoggedInByGuest() = userRepository.getIsLoggedInByGuest()

    suspend fun isLoggedInByAccount() = userRepository.getIsLoggedInByAccount()
}