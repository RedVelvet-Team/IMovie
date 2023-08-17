package com.redvelvet.repository.localDto

data class TvShowKeywordsLocalDto(
    val id: Int = 0,
    val tvShowKeywords: List<TvShowKeywordsResultLocalDto> = emptyList()
)

data class TvShowKeywordsResultLocalDto(
    val id: Int = 0,
    val name: String = ""
)