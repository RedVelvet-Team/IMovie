package com.redvelvet.viewmodel.see_all_episode
package com.redvelvet.viewmodel.episode

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