package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

interface CheckUserIsGuestUseCase {
    suspend operator fun invoke(userRepository: UserRepository):Boolean
}