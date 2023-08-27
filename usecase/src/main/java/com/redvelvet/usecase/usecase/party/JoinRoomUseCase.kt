package com.redvelvet.usecase.usecase.party

import com.redvelvet.usecase.repository.PartyRepository
import javax.inject.Inject

class JoinRoomUseCase @Inject constructor(
    private val partyRepository: PartyRepository,
) {
    suspend operator fun invoke(id: String) =
        partyRepository.joinRoom(id)
}