package com.redvelvet.entities.library

data class WatchListMedia(
    val data: List<Data>
) {
    data class Data(
        val id: Int,
        val posterPath: String,
        val name: String,
        val type: Type
    ) {
        enum class Type {
            MOVIE, TV
        }
    }
}