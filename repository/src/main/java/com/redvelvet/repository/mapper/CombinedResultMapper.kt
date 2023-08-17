package com.redvelvet.repository.mapper

import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.repository.dto.search.CombinedResultDto

fun CombinedResultDto.toCombinedResult() = CombinedResult(
    id = this.id ?: 0,
    mediaType = this.mediaType ?: "",
    name = this.name ?: this.title ?: "",
    language = this.originalLanguage ?: "",
    releaseDate = this.releaseDate ?: this.firstAirDate ?: "",
    imageUrl = "https://image.tmdb.org/t/p/w500"
                + (this.posterPath ?: this.backdropPath ?: this.posterPath ?: "")
)