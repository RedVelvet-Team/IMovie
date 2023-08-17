package com.redvelvet.repository.localDto

data class TvShowVideosLocalDto(
    val videos: List<TvShowResultVideoLocalDto> = emptyList()
)

data class TvShowResultVideoLocalDto(
    val site: String = "",
    val key: String = ""
)