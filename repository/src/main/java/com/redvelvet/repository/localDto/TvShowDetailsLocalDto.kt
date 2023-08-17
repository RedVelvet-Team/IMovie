package com.redvelvet.repository.localDto


data class TvShowDetailsLocalDto(
    val tvShowName:String = "",
    val tvShowImage:String = "",
    val tvShowLanguage:String = "",
    val tvShowDescription: String = "",
    val genres : List<String> = emptyList(),
    val voteAverage: Double = 0.0,
    val firstAirDate: String = "",
    val seasons : List<SeasonTvShowLocalDto> = emptyList()
)

data class SeasonTvShowLocalDto(
    val airDate: String = "",
    val seasonName: String = "",
    val posterSeason: String = "",
    val voteSeasonAverage: Double = 0.0,
    val seasonNumber: Int = 0,
    val episodeCount: Int = 0,
    val seasonDescription: String = "",
)


