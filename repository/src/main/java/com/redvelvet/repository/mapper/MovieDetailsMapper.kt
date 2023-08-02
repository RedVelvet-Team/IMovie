package com.redvelvet.repository.mapper

import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.repository.dto.movie.details.MovieImagesDTO
import com.redvelvet.repository.dto.movie.details.MovieKeyWordsDTO
import com.redvelvet.repository.dto.movie.details.MovieRecommendationsDTO
import com.redvelvet.repository.dto.movie.details.MovieReviewsDTO

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
