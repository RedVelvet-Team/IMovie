package com.redvelvet.repository.dto.library

import com.google.gson.annotations.SerializedName
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO

data class LibraryMovieDto(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
)