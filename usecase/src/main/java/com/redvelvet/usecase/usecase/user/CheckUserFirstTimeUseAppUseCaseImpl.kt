package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository


class CheckUserFirstTimeUseAppUseCaseImpl(private val userRepository: UserRepository) :
    CheckUserFirstTimeUseAppUseCase {
    override suspend fun invoke(): Boolean {
        return userRepository.getIsFirstTimeUsingApp()
    }

}