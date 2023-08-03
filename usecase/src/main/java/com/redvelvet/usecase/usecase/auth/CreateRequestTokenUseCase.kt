package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class CreateRequestTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke() = authRepository.createToken().requestToken.toString()
}