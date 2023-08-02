package com.redvelvet.repository.mapper

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.dto.search.BaseSearchDto
import com.redvelvet.repository.dto.search.SearchResultDto

fun SearchResultDto.toEntity(): SearchResult {
    return SearchResult(
        id = this.id,
        mediaType = this.mediaType,
        name = this.name,
        originCountry = this.originCountry?.firstOrNull(),
        posterPath = this.posterPath,
        releaseDate = this.releaseDate
    )
}

fun BaseSearchDto.toEntity(): List<SearchResult> {
    return this.searchResultDtos?.mapNotNull { it?.toEntity() } ?: emptyList()
}