package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

interface SetUserIsGuestUseCase {
    suspend operator fun invoke(userRepository: UserRepository)
}