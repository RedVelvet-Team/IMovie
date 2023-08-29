package com.redvelvet.viewmodel.episode

import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.viewmodel.episode.EpisodeCardUiState

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