package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class CheckUserLoggedInUseCaseImpl : CheckUserLoggedInUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsLoggedByAccount()
    }
}