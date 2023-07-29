package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository


class SetUserLoggedInUseCaseImpl (private val userRepository: UserRepository) :SetUserLoggedInUseCase {
    override suspend fun invoke() {
        userRepository.setIsLoggedByAccount(true)
    }
}