package com.redvelvet.viewmodel.episode

import com.redvelvet.entities.episode.EpisodeDetails


fun EpisodeDetails.toUiState(): Episode {
    return Episode(
        episodeDetails = Episode.Details(
            id = this.episodeDetails.id,
            name = this.episodeDetails.name,
            overview = this.episodeDetails.overview,
            runtime = this.episodeDetails.runtime,
            seasonNumber = this.episodeDetails.seasonNumber,
            episodeNumber = this.episodeDetails.episodeNumber,
            airDate = this.episodeDetails.airDate,
            stillPath = this.episodeDetails.stillPath,
            voteCount = this.episodeDetails.voteCount,
            voteAverage = this.episodeDetails.voteAverage
        ),
        episodeMovies = Episode.Movies(id = this.episodeMovies.id,
            results = this.episodeMovies.results.map {
                Episode.Movies.Result(
                    id = it.id,
                    name = it.name,
                    key = it.key,
                    site = it.site,
                    size = it.size,
                    type = it.type,
                    official = it.official,
                    publishedAt = it.publishedAt
                )
            }),
        episodeAccountStatus = Episode.Status(
            id = this.episodeAccountStatus.id, rated = this.episodeAccountStatus.rated.value
        ),
        episodeCast = Episode.Cast(id = this.episodeCast.id, cast = this.episodeCast.cast.map {
            Episode.Cast.Cast(
                id = it.id, name = it.name, profilePath = it.profilePath
            )
        }),
        episodeImages = Episode.Images(id = this.episodeImages.id,
            stills = this.episodeImages.stills.map {
                Episode.Images.Still(it.filePath)
            })
    )
}


data class Episode(
    val episodeDetails: Details,
    val episodeMovies: Movies,
    val episodeAccountStatus: Status,
    val episodeCast: Cast,
    val episodeImages: Images
) {
    data class Details(
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

    data class Movies(
        val id: Int, val results: List<Result>
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

    data class Status(
        val id: Int, val rated: Double
    )

    data class Cast(
        val id: Int,
        val cast: List<Cast>,
    ) {
        data class Cast(
            val id: Int, val name: String, val profilePath: String
        )
    }

    data class Images(
        val id: Int, val stills: List<Still>
    ) {
        data class Still(
            val filePath: String,
        )
    }
}

