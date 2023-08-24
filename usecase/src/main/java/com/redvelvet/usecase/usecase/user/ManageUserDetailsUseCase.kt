package com.redvelvet.usecase.usecase.user

import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class ManageUserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke() =
        userRepository.getUserNameFromLocal()

    suspend fun setUserName(userName: String) =
        userRepository.setUserName(userName)
}
