package com.redvelvet.repository.localDto

data class TvShowTopCastLocalDto(
    val cast: List<TvShowCastLocalDto> = emptyList(),
    val crew: List<TvShowCrewLocalDto> = emptyList()
)

data class TvShowCastLocalDto(
    val id: Int = 0,
    val name: String = "",
    val knownFoDepartment: String = "",
)

data class TvShowCrewLocalDto(
    val id: Int = 0,
    val name: String = "",
    val knownFoDepartment: String = "",
)
