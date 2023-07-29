package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository

interface CheckUserFirstTimeUseAppUseCase {
    suspend operator fun invoke(userRepository: UserRepository):Boolean
}