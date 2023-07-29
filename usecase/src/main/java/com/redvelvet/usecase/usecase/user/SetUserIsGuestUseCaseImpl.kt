package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class SetUserIsGuestUseCaseImpl (private val userRepository: UserRepository) : SetUserIsGuestUseCase {
    override suspend fun invoke() {
        userRepository.setIsLoggedByGuest(true)
    }
}