package com.redvelvet.repository.mapper

import com.redvelvet.entities.Genre
import com.redvelvet.repository.dto.GenreDto

fun GenreDto.toGenre() = Genre(
    id = this.id ?: 0,
    name = this.name ?: ""
)