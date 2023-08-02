package com.redvelvet.entities.tv

data class TvShow(
    val id: Int,
    val name:String,
    val image:String,
    val country: String?,
    val releaseDate: String?,
    val popularity: Double,
    )
