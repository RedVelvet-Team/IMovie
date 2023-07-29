package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CheckUserLoggedInUseCaseImpl @Inject constructor() : CheckUserLoggedInUseCase {
    override suspend fun invoke(userRepository: UserRepository): Boolean {
        return userRepository.getIsLoggedByAccount()
    }
}