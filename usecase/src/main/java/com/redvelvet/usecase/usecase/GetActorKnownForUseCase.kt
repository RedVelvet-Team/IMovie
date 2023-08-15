package com.redvelvet.usecase.usecase

import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetActorKnownForUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(id: Int, limit: Int? = null): List<CombinedResult> {
        val results = repository.getActorKnownFor(id)
        return limit?.let { results.take(it) } ?: results
    }

}