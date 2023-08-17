package com.redvelvet.entities.tv

data class TvShowKeywords(
    val id: Int? = null,
    val tvShowKeywords: List<TvShowKeywordsResult> = emptyList()
)

data class TvShowKeywordsResult(
    val id: Int = 0,
    val name: String = ""
)