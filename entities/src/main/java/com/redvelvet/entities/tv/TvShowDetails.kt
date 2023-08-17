package com.redvelvet.entities.tv

data class TvShowDetails(
    val tvShowName: String = "",
    val tvShowImage: String = "",
    val tvShowLanguage: String = "",
    val tvShowDescription: String = "",
    val genres: List<String> = emptyList(),
    val voteAverage: Double = 0.0,
    val firstAirDate: String = "",
    val seasons: List<SeasonTvShow> = emptyList()
)

data class SeasonTvShow(
    val seasonId: Int = 0,
    val airDate: String = "",
    val seasonName: String = "",
    val posterSeason: String = "",
    val voteSeasonAverage: Double = 0.0,
    val seasonNumber: Int = 0,
    val episodeCount: Int = 0,
    val seasonDescription: String = "",
)