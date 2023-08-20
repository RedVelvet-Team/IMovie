package com.redvelvet.repository.dto


import com.google.gson.annotations.SerializedName

data class SeasonDetailsDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("episodes")
    val episodeDto: List<EpisodeDto>?,
    @SerializedName("_id")
    val tvId: String?,
    @SerializedName("id")
    val seasonId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: Any?,
    @SerializedName("season_number")
    val seasonNumber: Int?,
    @SerializedName("vote_average")
    val voteAverage: Double?
)

data class EpisodeDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("episode_number")
    val episodeNumber: Int?,
    @SerializedName("episode_type")
    val episodeType: String?,
    @SerializedName("guest_stars")
    val guestStars: List<Any?>?,
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
    val voteCount: Int?
)