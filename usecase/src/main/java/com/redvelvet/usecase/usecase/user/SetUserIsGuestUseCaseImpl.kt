package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class SetUserIsGuestUseCaseImpl @Inject constructor() : SetUserIsGuestUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsLoggedByGuest(true)
    }
}