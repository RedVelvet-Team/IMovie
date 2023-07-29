package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class SetUserIsGuestUseCaseImpl  : SetUserIsGuestUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsLoggedByGuest(true)
    }
}