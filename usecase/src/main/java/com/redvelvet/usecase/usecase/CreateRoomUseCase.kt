package com.redvelvet.usecase.usecase

import com.redvelvet.usecase.repository.PartyRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.user.ManageUserDetailsUseCase
import javax.inject.Inject

class CreateRoomUseCase @Inject constructor(
    private val partyRepository: PartyRepository,
    private val manageUserDetailsUseCase: ManageUserDetailsUseCase,
) {
    suspend operator fun invoke() =
        partyRepository.createRoom(manageUserDetailsUseCase())

}