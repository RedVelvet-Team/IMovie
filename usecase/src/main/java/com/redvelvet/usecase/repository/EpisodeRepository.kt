package com.redvelvet.usecase.repository

import com.redvelvet.entities.episode.EpisodeDetails

interface EpisodeRepository {

    // region Episode Details
    suspend fun getEpisodeDetails(
        tvId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeDetails.EpisodeDetails

    suspend fun getEpisodeMovies(
        tvId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeDetails.EpisodeMovies

    suspend fun getEpisodeAccountStates(
        tvId: Int,
        seasonNumber: Int,
        episodeNumber: Int,
        sessionId: String
    ): EpisodeDetails.EpisodeAccountStatus

    suspend fun getEpisodeCast(
        tvId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeDetails.EpisodeCast

    suspend fun getEpisodeImages(
        tvId: Int,
        seasonNumber: Int,
        episodeNumber: Int
    ): EpisodeDetails.EpisodeImages
    // endregion
}