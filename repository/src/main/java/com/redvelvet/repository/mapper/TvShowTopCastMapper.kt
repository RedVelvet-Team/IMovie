package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowCast
import com.redvelvet.entities.tv.TvShowCrew
import com.redvelvet.entities.tv.TvShowTopCast
import com.redvelvet.repository.dto.tvShow.TvShowCastDto
import com.redvelvet.repository.dto.tvShow.TvShowCrewDto
import com.redvelvet.repository.dto.tvShow.TvShowTopCastDto
import com.redvelvet.repository.localDto.TvShowCastLocalDto
import com.redvelvet.repository.localDto.TvShowCrewLocalDto
import com.redvelvet.repository.localDto.TvShowTopCastLocalDto

fun TvShowTopCastDto.toTvShowTopCastLocalDto() = TvShowTopCastLocalDto(
    cast = cast?.map { it.toTvShowCastLocalDto() } ?: emptyList(),
    crew = crew?.map { it.toTvShowCrewLocalDto() } ?: emptyList()
)

fun TvShowCastDto.toTvShowCastLocalDto() = TvShowCastLocalDto(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TvShowCrewDto.toTvShowCrewLocalDto() = TvShowCrewLocalDto(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TvShowTopCastDto.toTvShowTopCast() = TvShowTopCast(
    cast = cast?.map { it.toTvShowCast() } ?: emptyList(),
    crew = crew?.map { it.toTvShowCrew() } ?: emptyList()
)

fun TvShowCastDto.toTvShowCast() = TvShowCast(
    id = id ?: 0,
    name = name ?: "",
    image = profilePath ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TvShowCrewDto.toTvShowCrew() = TvShowCrew(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)