package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject


class SaveGuestSessionUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(id: String, expDate: String) =
        userRepository.saveGuestSession(id, expDate)
}