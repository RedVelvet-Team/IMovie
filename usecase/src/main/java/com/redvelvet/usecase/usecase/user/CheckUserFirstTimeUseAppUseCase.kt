package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject


class CheckUserFirstTimeUseAppUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Boolean {
        return userRepository.getIsFirstTimeUsingApp()
    }
}