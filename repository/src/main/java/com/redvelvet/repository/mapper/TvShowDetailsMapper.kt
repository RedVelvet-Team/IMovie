package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.entities.tv.TvShowDetails
import com.redvelvet.repository.dto.schema.SeasonDto
import com.redvelvet.repository.dto.tvShow.TvShowDetailsDto
import com.redvelvet.repository.localDto.SeasonTvShowLocalDto
import com.redvelvet.repository.localDto.TvShowDetailsLocalDto

fun TvShowDetailsDto.toTvShowDetailsLocalDto() = TvShowDetailsLocalDto(
    tvShowName = name ?: "",
    tvShowImage = backdropPath ?: "",
    tvShowLanguage = originalLanguage ?: "",
    tvShowDescription = overview ?: "",
    genres = genres?.map { it?.name ?: "" } ?: emptyList(),
    voteAverage = voteAverage ?: 0.0,
    firstAirDate = firstAirDate ?: "",
    seasons = seasonDtos?.map { it?.toSeasonTvShowLocalDto() ?: SeasonTvShowLocalDto() } ?: emptyList()
)

fun SeasonDto.toSeasonTvShowLocalDto() = SeasonTvShowLocalDto(
    airDate = airDate ?: "",
    posterSeason = posterPath ?: "",
    voteSeasonAverage = voteAverage ?: 0.0,
    seasonNumber = seasonNumber ?: 0,
    episodeCount = episodeCount ?: 0,
    seasonName = name ?: "",
    seasonDescription = overview ?: ""
)

fun TvShowDetailsDto.toTvShowDetails() = TvShowDetails(
    tvShowId = id ?: 0,
    tvShowName = name ?: "",
    tvShowImage = backdropPath ?: "",
    tvShowLanguage = originalLanguage ?: "",
    tvShowDescription = overview ?: "",
    genres = genres?.map { it?.name ?: "" } ?: emptyList(),
    voteAverage = voteAverage ?: 0.0,
    firstAirDate = firstAirDate ?: "",
    seasons = seasonDtos?.map { it?.toSeasonTvShow() ?: SeasonTvShow() } ?: emptyList()
)

fun SeasonDto.toSeasonTvShow() = SeasonTvShow(
    seasonId = id ?: 0,
    airDate = airDate ?: "",
    posterSeason = "https://image.tmdb.org/t/p/w500$posterPath",
    voteSeasonAverage = voteAverage ?: 0.0,
    seasonNumber = seasonNumber ?: 0,
    episodeCount = episodeCount ?: 0,
    seasonName = name ?: "",
    seasonDescription = overview ?: ""
)