package com.redvelvet.entities.tv

data class TvShowTopCast(
    val cast: List<TvShowCast> = emptyList(),
    val crew: List<TvShowCrew> = emptyList()
)

data class TvShowCast(
    val id: Int = 0,
    val name: String = "",
    val knownFoDepartment: String = "",
)

data class TvShowCrew(
    val id: Int = 0,
    val name: String = "",
    val knownFoDepartment: String = "",
)