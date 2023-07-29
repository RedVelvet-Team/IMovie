package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class CheckUserIsGuestUseCaseImpl  : CheckUserIsGuestUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsLoggedByGuest()
    }
}