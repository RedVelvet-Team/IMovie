package com.redvelvet.usecase.usecase.party

import com.redvelvet.usecase.repository.PartyRepository
import javax.inject.Inject

class StreamMovieUseCase @Inject constructor(
    private val partyRepository: PartyRepository,
) {
    suspend operator fun invoke(roomId: String) =
        partyRepository.streamMovie(roomId)
}