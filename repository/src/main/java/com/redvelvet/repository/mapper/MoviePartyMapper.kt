package com.redvelvet.repository.mapper

import com.redvelvet.entities.MovieParty
import com.redvelvet.repository.dto.party.MoviePartyDto

fun MoviePartyDto.toMovieParty(): MovieParty{
    return MovieParty(
        id = id?: "",
        adminName = adminName?: "",
        movieLink = movieLink?: "",
        isStopped = isStopped?: true,
    )
}