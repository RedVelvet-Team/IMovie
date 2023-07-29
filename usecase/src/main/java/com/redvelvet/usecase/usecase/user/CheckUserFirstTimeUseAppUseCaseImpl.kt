package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository


class CheckUserFirstTimeUseAppUseCaseImpl  : CheckUserFirstTimeUseAppUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsFirstTimeUsingApp()
    }

}