package com.redvelvet.repository.dto.library.rated.user


import com.google.gson.annotations.SerializedName

data class UserRatedTvDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
) {
    data class Result(
        @SerializedName("adult")
        val adult: Boolean?,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        @SerializedName("genre_ids")
        val genreIds: List<Int?>?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("origin_country")
        val originCountry: List<String?>?,
        @SerializedName("original_language")
        val originalLanguage: String?,
        @SerializedName("original_name")
        val originalName: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("popularity")
        val popularity: Double?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("first_air_date")
        val firstAirDate: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?,
        @SerializedName("rating")
        val rating: Double?
    )
}