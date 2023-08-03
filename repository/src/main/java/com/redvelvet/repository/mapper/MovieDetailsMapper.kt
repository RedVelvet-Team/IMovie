package com.redvelvet.repository.mapper

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO
import com.redvelvet.repository.dto.movie.details.MovieSimilarDTO
import com.redvelvet.repository.dto.movie.details.MovieTopCastDto

fun MovieImagesDTO.toDomain(): MovieImages {
    return MovieImages(backdrops = this.backdrops.map { MovieImages.Backdrop(it.filePath) },
        id = this.id,
        logos = this.logos.map { MovieImages.Logo(it.filePath) },
        posters = this.posters.map { MovieImages.Poster(it.filePath) })
}

fun MovieKeyWordsDTO.toDomain(): MovieKeyWords {
    return MovieKeyWords(id = this.id,
        keywords = this.keywords.map { MovieKeyWords.Keyword(it.id, it.name) })
}

fun MovieRecommendationsDTO.toDomain(): MovieRecommendations {
    return MovieRecommendations(results = this.results.map {
        MovieRecommendations.Result(
            it.id,
            it.title,
            it.posterPath
        )
    })
}

fun MovieReviewsDTO.toDomain(): MovieReviews {
    return MovieReviews(id = this.id, results = this.results.map {
        MovieReviews.Result(
                id = it.id,
                name = it.authorDetails.name,
                username = it.authorDetails.username,
                content = it.content,
                createdAt = it.createdAt,
                url = it.url,
                rating = it.authorDetails.rating
            )
    })
}

fun MovieSimilarDTO.toDomain(): MovieSimilar {
    return MovieSimilar(result = this.results.map {
        MovieSimilar.Result(
            id = it.id, title = it.title, posterPath = it.posterPath
        )
    })
}

fun MovieTopCastDto.toDomain(): MovieTopCast {
    return MovieTopCast(id = this.id,
        cast = this.cast.map {
            MovieTopCast.Cast(
                id = it.id,
                name = it.name,
                profilePath = it.profilePath
            )
        }
    )
}

fun MovieDetailsDTO.toDomain(): MovieDetails {
    return MovieDetails(
        genres = genres.map { MovieDetails.Genre(it.id, it.name) },
        homepage = homepage,
        id = id,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        productionCountries = productionCountries.map {
            MovieDetails.ProductionCountry(
                it.iso31661,
                it.name
            )
        },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = "$runtime min",
        spokenLanguages = spokenLanguages.map { MovieDetails.SpokenLanguage(it.englishName) },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
    )
}