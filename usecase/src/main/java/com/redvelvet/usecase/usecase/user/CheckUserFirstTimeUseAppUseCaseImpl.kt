package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CheckUserFirstTimeUseAppUseCaseImpl @Inject constructor() : CheckUserFirstTimeUseAppUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsFirstTimeUsingApp()
    }

}