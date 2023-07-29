package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class SetUserIsGuestUseCaseImpl @Inject constructor (private val userRepository: UserRepository)  {
     suspend fun invoke() {
        userRepository.setIsLoggedByGuest(true)
    }
}