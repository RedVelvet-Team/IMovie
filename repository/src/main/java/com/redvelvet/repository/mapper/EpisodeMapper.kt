package com.redvelvet.repository.mapper

import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.repository.dto.EpisodeDto

fun EpisodeDto.toEpisodeDetails(): EpisodeDetails {
    return EpisodeDetails(
        id = id ?: 0,
        name = name.orEmpty(),
        airDate = airDate.orEmpty(),
        voteAverage = voteAverage ?:0.0,
        runtime = runtime ?:0,
        image = "https://image.tmdb.org/t/p/w500$stillPath"
    )
}