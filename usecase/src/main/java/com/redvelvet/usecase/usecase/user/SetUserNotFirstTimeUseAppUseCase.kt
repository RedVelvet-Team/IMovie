package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

interface SetUserNotFirstTimeUseAppUseCase {
    suspend operator fun invoke(userRepository: UserRepository)
}