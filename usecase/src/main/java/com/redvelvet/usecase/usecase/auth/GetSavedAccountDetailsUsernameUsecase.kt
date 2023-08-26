package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class GetSavedAccountDetailsUsernameUsecase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(): String {
        return authRepository.getAccountDetailsUsernameFromLocal() ?: ""
    }
}