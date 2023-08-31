package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowCast
import com.redvelvet.entities.tv.TvShowCrew
import com.redvelvet.entities.tv.TvShowTopCast
import com.redvelvet.repository.dto.schema.TopCastDto
import com.redvelvet.repository.localDto.TvShowCastLocalDto
import com.redvelvet.repository.localDto.TvShowCrewLocalDto
import com.redvelvet.repository.localDto.TvShowTopCastLocalDto

fun TopCastDto.toTvShowTopCastLocalDto() = TvShowTopCastLocalDto(
    cast = cast.map { it.toTvShowCastLocalDto() } ?: emptyList(),
    crew = crew.map { it.toTvShowCrewLocalDto() } ?: emptyList()
)

fun TopCastDto.Cast.toTvShowCastLocalDto() = TvShowCastLocalDto(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TopCastDto.Crew.toTvShowCrewLocalDto() = TvShowCrewLocalDto(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TopCastDto.toTvShowTopCast() = TvShowTopCast(
    cast = cast.map { it.toTvShowCast() } ?: emptyList(),
    crew = crew.map { it.toTvShowCrew() } ?: emptyList()
)

fun TopCastDto.Cast.toTvShowCast() = TvShowCast(
    id = id ?: 0,
    name = name ?: "",
    image = profilePath ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)

fun TopCastDto.Crew.toTvShowCrew() = TvShowCrew(
    id = id ?: 0,
    name = name ?: "",
    knownFoDepartment = knownForDepartment ?: ""
)