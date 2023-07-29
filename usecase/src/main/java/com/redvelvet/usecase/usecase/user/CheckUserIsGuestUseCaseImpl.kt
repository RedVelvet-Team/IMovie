package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CheckUserIsGuestUseCaseImpl @Inject constructor() : CheckUserIsGuestUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsLoggedByGuest()
    }
}