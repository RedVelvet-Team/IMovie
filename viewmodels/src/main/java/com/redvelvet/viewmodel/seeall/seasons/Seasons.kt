package com.redvelvet.viewmodel.seeall.seasons

import com.redvelvet.entities.tv.SeasonTvShow

fun SeasonTvShow.toSeasonUiState(): SeasonUiState {
    return SeasonUiState(
        imageUrl = posterSeason,
        seasonNumber = seasonNumber,
        rate = voteSeasonAverage,
        airDate = airDate,
        episodesNum = episodeCount,
        description = seasonDescription
    )
}