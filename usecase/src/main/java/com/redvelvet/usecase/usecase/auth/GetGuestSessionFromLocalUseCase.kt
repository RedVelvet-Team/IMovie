package com.redvelvet.usecase.usecase.auth

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject


class GetGuestSessionFromLocalUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke() = userRepository.getGuestSessionFromLocal()
}