package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class SetUserLoggedInUseCaseImpl @Inject constructor() : SetUserLoggedInUseCase {
    override suspend fun invoke(userRepository: UserRepository) {
        userRepository.setIsLoggedByAccount(true)
    }
}