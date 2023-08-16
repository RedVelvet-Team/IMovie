package com.redvelvet.repository.mapper

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.repository.dto.movie.details.*

fun MovieImagesDTO.toDomain(): MovieImages {
    return MovieImages(backdrops = this.backdrops.map { MovieImages.Backdrop(it.filePath ?: "N/A") },
        id = this.id ?: 0,
        logos = this.logos.map { MovieImages.Logo(it.filePath ?: "N/A") },
        posters = this.posters.map { MovieImages.Poster(it.filePath ?: "N/A") })
}

fun MovieKeyWordsDTO.toDomain(): MovieKeyWords {
    return MovieKeyWords(id = this.id ?: 0,
        keywords = this.keywords.map { MovieKeyWords.Keyword(it.id ?: 0, it.name?: "N/A") })
}

fun MovieRecommendationsDTO.toDomain(): MovieRecommendations {
    return MovieRecommendations(results = this.results.map {
        MovieRecommendations.Result(
            it.id ?: 0,
            it.title ?: "N/A",
            it.posterPath ?: "N/A"
        )
    })
}

fun MovieReviewsDTO.toDomain(): MovieReviews {
    return MovieReviews(id = this.id ?: 0, results = this.results.map {
        MovieReviews.Result(
                id = it.id ?: "N/A",
                name = it.authorDetails?.name ?: "N/A",
                username = it.authorDetails?.username ?: "N/A",
                content = it.content ?: "N/A",
                createdAt = it.createdAt ?: "N/A",
                url = it.url?: "N/A",
                rating = it.authorDetails?.rating ?: 0.0
            )
    })
}

fun MovieSimilarDTO.toDomain(): MovieSimilar {
    return MovieSimilar(result = this.results.map {
        MovieSimilar.Result(
            id = it.id ?: 0, title = it.title ?: "N/A", posterPath = it.posterPath ?: "N/A"
        )
    })
}

fun MovieTopCastDto.toDomain(): MovieTopCast {
    return MovieTopCast(id = this.id ?: 0,
        cast = this.cast.map {
            MovieTopCast.Cast(
                id = it.id ?: 0,
                name = it.name ?: "N/A",
                profilePath = it.profilePath ?: "N/A"
            )
        }
    )
}

fun MovieDetailsDTO.toDomain(): MovieDetails {
    return MovieDetails(
        genres = genres.map { MovieDetails.Genre(it.id ?: 0, it.name ?: "N/A") },
        homepage = homepage ?: "N/A",
        id = id ?: 0,
        originalTitle = originalTitle ?: "N/A",
        overview = overview ?: "N/A",
        posterPath = posterPath ?: "N/A",
        productionCountries = productionCountries.map {
            MovieDetails.ProductionCountry(
                it.iso31661  ?: "N/A",
                it.name  ?: "N/A"
            )
        },
        releaseDate = releaseDate ?: "N/A",
        revenue = revenue ?: 0,
        runtime = "$runtime min",
        spokenLanguages = spokenLanguages.map { MovieDetails.SpokenLanguage(it.englishName  ?: "N/A") },
        status = status ?: "N/A",
        tagline = tagline ?: "N/A",
        title = title ?: "N/A",
        video = video ?: true,
        voteAverage = voteAverage ?: 0.0,
    )
}
