package com.redvelvet.repository.mapper

import com.redvelvet.entities.Genre
import com.redvelvet.repository.dto.GenresDto

fun GenresDto.toGenreList(): List<Genre> {
    return genres.map { genre ->
        Genre(
            id = genre.id ?: 0,
            name = genre.name ?: ""
        )
    }
}
