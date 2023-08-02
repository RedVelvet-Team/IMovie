package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CreateRequestTokenUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    //suspend operator fun invoke() = userRepository.getNewRequestToken()
}