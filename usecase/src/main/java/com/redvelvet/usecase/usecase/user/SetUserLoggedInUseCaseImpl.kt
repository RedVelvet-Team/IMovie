package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository


class SetUserLoggedInUseCaseImpl  :SetUserLoggedInUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsLoggedByAccount(true)
    }
}