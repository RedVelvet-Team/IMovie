package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName

data class EpisodeSingleItemDto(
    val episodeDetails: EpisodeDetails,
    val episodeMovies: EpisodeMovies,
    val episodeCast: EpisodeCast,
    val episodeImages: EpisodeImages
) {
    data class EpisodeDetails(
        @SerializedName("air_date")
        val airDate: String?,
        @SerializedName("crew")
        val crew: List<Crew>,
        @SerializedName("episode_number")
        val episodeNumber: Int?,
        @SerializedName("guest_stars")
        val guestStars: List<GuestStar>,
        @SerializedName("name")
        val name: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("production_code")
        val productionCode: String?,
        @SerializedName("runtime")
        val runtime: Int?,
        @SerializedName("season_number")
        val seasonNumber: Int?,
        @SerializedName("still_path")
        val stillPath: String?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?
    ) {
        data class Crew(
            @SerializedName("department")
            val department: String?,
            @SerializedName("job")
            val job: String?,
            @SerializedName("credit_id")
            val creditId: String?,
            @SerializedName("adult")
            val adult: Boolean?,
            @SerializedName("gender")
            val gender: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("known_for_department")
            val knownForDepartment: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original_name")
            val originalName: String?,
            @SerializedName("popularity")
            val popularity: Double?,
            @SerializedName("profile_path")
            val profilePath: String?
        )

        data class GuestStar(
            @SerializedName("character")
            val character: String?,
            @SerializedName("credit_id")
            val creditId: String?,
            @SerializedName("order")
            val order: Int?,
            @SerializedName("adult")
            val adult: Boolean?,
            @SerializedName("gender")
            val gender: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("known_for_department")
            val knownForDepartment: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original_name")
            val originalName: String?,
            @SerializedName("popularity")
            val popularity: Double?,
            @SerializedName("profile_path")
            val profilePath: String?
        )
    }

    data class EpisodeMovies(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("results")
        val results: List<Result>
    ) {
        data class Result(
            @SerializedName("iso_639_1")
            val iso6391: String?,
            @SerializedName("iso_3166_1")
            val iso31661: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("key")
            val key: String?,
            @SerializedName("site")
            val site: String?,
            @SerializedName("size")
            val size: Int?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("official")
            val official: Boolean?,
            @SerializedName("published_at")
            val publishedAt: String?,
            @SerializedName("id")
            val id: String?
        )
    }

    data class EpisodeCast(
        @SerializedName("cast")
        val cast: List<Cast>,
        @SerializedName("crew")
        val crew: List<Crew>,
        @SerializedName("guest_stars")
        val guestStars: List<GuestStar>,
        @SerializedName("id")
        val id: Int?
    ) {
        data class Cast(
            @SerializedName("adult")
            val adult: Boolean?,
            @SerializedName("gender")
            val gender: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("known_for_department")
            val knownForDepartment: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original_name")
            val originalName: String?,
            @SerializedName("popularity")
            val popularity: Double?,
            @SerializedName("profile_path")
            val profilePath: String?,
            @SerializedName("character")
            val character: String?,
            @SerializedName("credit_id")
            val creditId: String?,
            @SerializedName("order")
            val order: Int?
        )

        data class Crew(
            @SerializedName("department")
            val department: String?,
            @SerializedName("job")
            val job: String?,
            @SerializedName("credit_id")
            val creditId: String?,
            @SerializedName("adult")
            val adult: Boolean?,
            @SerializedName("gender")
            val gender: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("known_for_department")
            val knownForDepartment: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original_name")
            val originalName: String?,
            @SerializedName("popularity")
            val popularity: Double?,
            @SerializedName("profile_path")
            val profilePath: String?
        )

        data class GuestStar(
            @SerializedName("character")
            val character: String?,
            @SerializedName("credit_id")
            val creditId: String?,
            @SerializedName("order")
            val order: Int?,
            @SerializedName("adult")
            val adult: Boolean?,
            @SerializedName("gender")
            val gender: Int?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("known_for_department")
            val knownForDepartment: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("original_name")
            val originalName: String?,
            @SerializedName("popularity")
            val popularity: Double?,
            @SerializedName("profile_path")
            val profilePath: String?
        )
    }

    data class EpisodeImages(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("stills")
        val stills: List<Still>
    ) {
        data class Still(
            @SerializedName("aspect_ratio")
            val aspectRatio: Double?,
            @SerializedName("height")
            val height: Int?,
            @SerializedName("iso_639_1")
            val iso6391: String?,
            @SerializedName("file_path")
            val filePath: String?,
            @SerializedName("vote_average")
            val voteAverage: Double?,
            @SerializedName("vote_count")
            val voteCount: Int?,
            @SerializedName("width")
            val width: Int?
        )
    }
}
