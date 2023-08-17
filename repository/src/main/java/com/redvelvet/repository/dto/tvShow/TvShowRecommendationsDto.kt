package com.redvelvet.repository.dto.tvShow


import com.google.gson.annotations.SerializedName

data class TvShowRecommendationsDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TvShowRecommendationResult?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)

data class TvShowRecommendationResult(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Int?>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("name")
    val name: String?,
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
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
)