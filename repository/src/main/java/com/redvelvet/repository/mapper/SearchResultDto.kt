package com.redvelvet.repository.mapper

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.dto.search.BaseSearchDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto

fun MultiSearchResultDto.toEntity(): SearchResult {
    return SearchResult(
        id = this.id,
        mediaType = this.mediaType,
        name = this.name,
        language = this.originalLanguage,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        firstAirDate = this.firstAirDate,
        originalName = this.title,
        profilePath = this.profilePath
    )
}

fun BaseSearchDto.toEntity(): List<SearchResult> {
    return this.multiSearchResultDtos?.mapNotNull { it?.toEntity() } ?: emptyList()
}