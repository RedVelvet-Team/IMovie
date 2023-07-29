package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

interface CheckUserLoggedInUseCase {
    suspend operator fun invoke(userRepository: UserRepository):Boolean
}