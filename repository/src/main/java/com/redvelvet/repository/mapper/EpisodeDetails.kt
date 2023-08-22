package com.redvelvet.repository.mapper

import com.redvelvet.entities.episode.EpisodeDetails
import com.redvelvet.repository.dto.EpisodeSingleItemDto

private const val NO_DATA = "N/A"

fun EpisodeSingleItemDto.EpisodeDetails.mapToDomain(): EpisodeDetails.EpisodeDetails {
    return EpisodeDetails.EpisodeDetails(
        id = this.id ?: 0,
        name = this.name ?: NO_DATA,
        overview = this.overview ?: NO_DATA,
        runtime = this.runtime ?: 0,
        seasonNumber = this.seasonNumber ?: 0,
        episodeNumber = this.episodeNumber ?: 0,
        airDate = this.airDate ?: NO_DATA,
        stillPath = this.stillPath ?: NO_DATA,
        voteCount = this.voteCount ?: 0,
        voteAverage = this.voteAverage ?: 0.0
    )
}

fun EpisodeSingleItemDto.EpisodeMovies.mapToDomain(): EpisodeDetails.EpisodeMovies {
    return EpisodeDetails.EpisodeMovies(
        id = this.id ?: 0,
        results = this.results.map { resultDto ->
            EpisodeDetails.EpisodeMovies.Result(
                id = resultDto.id ?: NO_DATA,
                name = resultDto.name ?: NO_DATA,
                key = resultDto.key ?: NO_DATA,
                site = resultDto.site ?: NO_DATA,
                size = resultDto.size ?: 0,
                type = resultDto.type ?: NO_DATA,
                official = resultDto.official ?: false,
                publishedAt = resultDto.publishedAt ?: NO_DATA
            )
        })
}

fun EpisodeSingleItemDto.EpisodeAccountStatus.mapTODomain(): EpisodeDetails.EpisodeAccountStatus {
    return EpisodeDetails.EpisodeAccountStatus(
        id = this.id ?: 0,
        rated = EpisodeDetails.EpisodeAccountStatus.Rated(
            value = this.rated.value ?: 0.0
        )
    )
}

fun EpisodeSingleItemDto.EpisodeCast.mapTODomain(): EpisodeDetails.EpisodeCast {
    return EpisodeDetails.EpisodeCast(cast = this.cast.map { castDto ->
        EpisodeDetails.EpisodeCast.Cast(
            id = castDto.id ?: 0,
            name = castDto.name ?: NO_DATA,
            profilePath = castDto.profilePath ?: NO_DATA
        )
    })
}

fun EpisodeSingleItemDto.EpisodeImages.mapTODomain(): EpisodeDetails.EpisodeImages {
    return EpisodeDetails.EpisodeImages(
        id = this.id ?: 0,
        stills = this.stills.map { stillDto ->
            EpisodeDetails.EpisodeImages.Still(
                filePath = stillDto.filePath ?: NO_DATA
            )
        })
}

fun EpisodeSingleItemDto.mapToDomain(): EpisodeDetails {
    return EpisodeDetails(
        episodeDetails = this.episodeDetails.mapToDomain(),
        episodeMovies = this.episodeMovies.mapToDomain(),
        episodeAccountStatus = this.episodeAccountStatus.mapTODomain(),
        episodeCast = this.episodeCast.mapTODomain(),
        episodeImages = this.episodeImages.mapTODomain()
    )
}