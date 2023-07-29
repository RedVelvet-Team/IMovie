package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class SetUserNotFirstTimeUseAppUseCaseImpl  :
    SetUserNotFirstTimeUseAppUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsFirstTimeUsingApp(false)
    }
}