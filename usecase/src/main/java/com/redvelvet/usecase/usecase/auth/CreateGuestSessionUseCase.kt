package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class CreateGuestSessionUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val saveGuestSessionUseCase: SaveGuestSessionUseCase,
) {
    suspend operator fun invoke() = userRepository.createGuestSession()
}