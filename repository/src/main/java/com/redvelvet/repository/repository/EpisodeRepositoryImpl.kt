package com.redvelvet.repository.repository

import com.redvelvet.entities.episode.EpisodeDetails
import com.redvelvet.repository.mapper.mapTODomain
import com.redvelvet.repository.mapper.mapToDomain
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : EpisodeRepository {

    override suspend fun getEpisodeDetails(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeDetails {
        return remoteDataSource.getEpisodeDetails(tvId, seasonNumber, episodeNumber).mapToDomain()
    }

    override suspend fun getEpisodeMovies(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeMovies {
        return remoteDataSource.getEpisodeMovies(tvId, seasonNumber, episodeNumber).mapToDomain()
    }

    override suspend fun getEpisodeAccountStates(
        tvId: Int, seasonNumber: Int, episodeNumber: Int, sessionId: String
    ): EpisodeDetails.EpisodeAccountStatus {
        return remoteDataSource.getEpisodeAccountStates(
            tvId,
            seasonNumber,
            episodeNumber,
            sessionId
        ).mapTODomain()
    }

    override suspend fun getEpisodeCast(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeCast {
        return remoteDataSource.getEpisodeCast(tvId, seasonNumber, episodeNumber).mapTODomain()
    }

    override suspend fun getEpisodeImages(
        tvId: Int, seasonNumber: Int, episodeNumber: Int
    ): EpisodeDetails.EpisodeImages {
        return remoteDataSource.getEpisodeImages(tvId, seasonNumber, episodeNumber).mapTODomain()
    }
}