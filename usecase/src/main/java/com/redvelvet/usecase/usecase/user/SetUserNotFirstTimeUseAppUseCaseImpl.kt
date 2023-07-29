package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class SetUserNotFirstTimeUseAppUseCaseImpl(private val userRepository: UserRepository) :
    SetUserNotFirstTimeUseAppUseCase {
    override suspend fun invoke() {
        userRepository.setIsFirstTimeUsingApp(false)
    }
}