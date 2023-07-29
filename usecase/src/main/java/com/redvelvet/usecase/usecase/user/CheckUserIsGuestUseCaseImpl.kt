package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

class CheckUserIsGuestUseCaseImpl (private val userRepository: UserRepository) : CheckUserIsGuestUseCase {
    override suspend fun invoke(): Boolean {
        return userRepository.getIsLoggedByGuest()
    }
}