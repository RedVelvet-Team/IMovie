package com.redvelvet.local.localdto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("movie_table")
data class MovieLocalDTO(
    @PrimaryKey val leagueId: Int,
    val leagueName: String,
    val leagueSeason: Int,
    val leagueLogoUrl: String,
    val seasonStartYear: String,
    val seasonEndYear: String,
    val country: String,
    val isFavourite: Boolean,
    val typeName: String
)