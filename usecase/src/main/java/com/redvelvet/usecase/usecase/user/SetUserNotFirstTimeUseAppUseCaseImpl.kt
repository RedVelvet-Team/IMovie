package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class SetUserNotFirstTimeUseAppUseCaseImpl @Inject constructor() :
    SetUserNotFirstTimeUseAppUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsFirstTimeUsingApp(false)
    }
}