package com.redvelvet.usecase.usecase

import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke (tvId: String, seasonNumber: Int) : List <EpisodeDetails> {
        return movieRepository.getAllEpisodes(tvId,seasonNumber)
    }
}