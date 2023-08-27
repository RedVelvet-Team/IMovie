package com.redvelvet.usecase.usecase.episode

import com.redvelvet.entities.episode.EpisodeDetails
import com.redvelvet.usecase.repository.EpisodeRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetEpisodeDetailsUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository
) {

    suspend operator fun invoke(
        tvId: Int, seasonNumber: Int, episodeNumber: Int, sessionId: String
    ): EpisodeDetails = coroutineScope {

        try {
            val episodeDetailsDef = async { getEpisodeDetails(tvId, seasonNumber, episodeNumber) }
            val episodeMoviesDef = async { getEpisodeMovies(tvId, seasonNumber, episodeNumber) }
            val episodeCastDef = async { getEpisodeCast(tvId, seasonNumber, episodeNumber) }
            val episodeImagesDef = async { getEpisodeImages(tvId, seasonNumber, episodeNumber) }

            val episodeDetails = episodeDetailsDef.await()
            val episodeMovies = episodeMoviesDef.await()
            val episodeCast = episodeCastDef.await()
            val episodeImages = episodeImagesDef.await()
            EpisodeDetails(
                episodeDetails = episodeDetails,
                episodeMovies = episodeMovies,
                episodeCast = episodeCast,
                episodeImages = episodeImages
            )
        } catch (e: Exception) {
            throw e
        }
    }

    private suspend fun getEpisodeDetails(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeDetails {
        return episodeRepository.getEpisodeDetails(tvId, seasonNumber, episodeNumber)
    }

    private suspend fun getEpisodeMovies(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeMovies {
        return episodeRepository.getEpisodeMovies(tvId, seasonNumber, episodeNumber)
    }

    private suspend fun getEpisodeCast(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeCast {
        return episodeRepository.getEpisodeCast(tvId, seasonNumber, episodeNumber)
    }


    private suspend fun getEpisodeImages(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeImages {
        return episodeRepository.getEpisodeImages(tvId, seasonNumber, episodeNumber)
    }
}