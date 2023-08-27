package com.redvelvet.entities.episode

data class EpisodeDetails(
    val episodeDetails: EpisodeDetails,
    val episodeMovies: EpisodeMovies,
    val episodeAccountStatus: EpisodeAccountStatus,
    val episodeCast: EpisodeCast,
    val episodeImages: EpisodeImages
) {
    data class EpisodeDetails(
        val id: Int,
        val name: String,
        val overview: String,
        val runtime: Int,
        val seasonNumber: Int,
        val episodeNumber: Int,
        val airDate: String,
        val stillPath: String,
        val voteCount: Int,
        val voteAverage: Double
    )

    data class EpisodeMovies(
        val id: Int,
        val results: List<Result>
    ) {
        data class Result(
            val id: String,
            val name: String,
            val key: String,
            val site: String,
            val size: Int,
            val type: String,
            val official: Boolean,
            val publishedAt: String,
        )
    }

    data class EpisodeAccountStatus(
        val id: Int,
        val rated: Rated
    ) {
        data class Rated(
            val value: Double
        )
    }

    data class EpisodeCast(
        val id: Int,
        val cast: List<Cast>,
    ) {
        data class Cast(
            val id: Int,
            val name: String,
            val profilePath: String
        )
    }

    data class EpisodeImages(
        val id: Int,
        val stills: List<Still>
    ) {
        data class Still(
            val filePath: String,
        )
    }
}

