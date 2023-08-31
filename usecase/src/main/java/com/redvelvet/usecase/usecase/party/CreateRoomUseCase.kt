package com.redvelvet.usecase.usecase.party

import com.redvelvet.usecase.repository.PartyRepository
import com.redvelvet.usecase.usecase.user.ManageUserDetailsUseCase
import javax.inject.Inject

class CreateRoomUseCase @Inject constructor(
    private val partyRepository: PartyRepository,
    private val manageUserDetailsUseCase: ManageUserDetailsUseCase,
) {
    suspend operator fun invoke() =
        getRandomId().apply {
            partyRepository.createRoom(manageUserDetailsUseCase(), this)
        }

    private fun getRandomId() = System.currentTimeMillis().toString()
}