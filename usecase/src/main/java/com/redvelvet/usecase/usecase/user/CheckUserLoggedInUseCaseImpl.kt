package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class CheckUserLoggedInUseCaseImpl (private val userRepository: UserRepository) : CheckUserLoggedInUseCase {
    override suspend fun invoke(): Boolean {
        return userRepository.getIsLoggedByAccount()
    }
}