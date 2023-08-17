package com.redvelvet.viewmodel.seeall.episode

import com.redvelvet.entities.EpisodeDetails

fun EpisodeDetails.toEpisodeCardUiState(): EpisodeCardUiState {
    return EpisodeCardUiState(
        id = id,
        name = name ,
        airDate= airDate ,
        voteAverage = voteAverage ,
        runtime = runtime,
        image = image
    )
}