package com.redvelvet.usecase.usecase

import com.redvelvet.entities.actor.Actor
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetActorDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(id: String): Actor {
        return repository.getActorDetails(id)
    }
}