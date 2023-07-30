package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class SetUserNotFirstTimeUseAppUseCaseImpl @Inject constructor(private val userRepository: UserRepository) {
    suspend fun invoke(isFirstTime: Boolean) {
        userRepository.setIsFirstTimeUsingApp(isFirstTime)
    }
}