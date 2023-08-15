package com.redvelvet.entities.movie.details

data class MovieKeyWords(
    val id: Int,
    val keywords: List<Keyword>
) {
    data class Keyword(
        val id: Int,
        val name: String
    )
}