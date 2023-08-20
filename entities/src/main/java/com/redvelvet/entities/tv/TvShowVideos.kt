package com.redvelvet.entities.tv

data class TvShowVideos(
    val videos: List<TvShowResultVideo> = emptyList()
)

data class TvShowResultVideo(
    val site: String = "",
    val key: String = ""
)