package com.redvelvet.repository.dto.library.rated.user


import com.google.gson.annotations.SerializedName

data class UserRatedEpisodesDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
) {
    data class Result(
        @SerializedName("air_date")
        val airDate: String?,
        @SerializedName("episode_number")
        val episodeNumber: Int?,
        @SerializedName("episode_type")
        val episodeType: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("production_code")
        val productionCode: String?,
        @SerializedName("runtime")
        val runtime: Int?,
        @SerializedName("season_number")
        val seasonNumber: Int?,
        @SerializedName("show_id")
        val showId: Int?,
        @SerializedName("still_path")
        val stillPath: String?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?,
        @SerializedName("rating")
        val rating: Double?
    )
}