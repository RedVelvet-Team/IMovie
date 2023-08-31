package com.redvelvet.viewmodel.details_ui_states


import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.entities.tv.TvShowCast
import com.redvelvet.entities.tv.TvShowRecommendation
import com.redvelvet.entities.tv.TvShowReview
import com.redvelvet.viewmodel.utils.Constants


fun MovieFullDetails.toUiState(): MediaDetailsScreenUiState.AllMediaDetailsUiState {
    return MediaDetailsScreenUiState.AllMediaDetailsUiState(
        details = this.details.toUiState(),
        topCast = this.topCast.cast.map { it.toUiState() },
        keyWords = this.keyWords.keywords.map { it.name },
        similar = this.similar.result.map { it.toUiState() },
        images = this.images.posters.map { it.filePath },
        reviews = this.reviews.results.map { it.toUiState() },
        tvSeasons = emptyList(),
        recommendations = this.recommendations.results.map { it.toUiState() }
    )
}

fun TvShowAllDetails.toUiState(): MediaDetailsScreenUiState.AllMediaDetailsUiState {
    return MediaDetailsScreenUiState.AllMediaDetailsUiState(
        details = MediaDetailsScreenUiState.MediaDetailsUiState(
            genres = genres,
            id = tvShowId,
            mediaTrailerUrl = tvShowTrailerUrl,
            overview = tvShowDescription,
            posterPath = Constants.BASE_IMAGE_URL + tvShowImage,
            releaseDate = firstAirDate,
            spokenLanguages = tvShowLanguage,
            title = tvShowName,
            voteAverage = voteAverage,
        ),
        topCast = topCast.map { it.toUiState() },
        keyWords = this.keywords,
        similar = emptyList(),
        images = this.posters,
        reviews = this.reviews.map { it.toUiState() },
        tvSeasons = this.seasons.map { it.toUiState() },
        recommendations = this.recommendations.map { it.toUiState() }
    )
}


fun MovieDetails.toUiState(): MediaDetailsScreenUiState.MediaDetailsUiState {
    return MediaDetailsScreenUiState.MediaDetailsUiState(
        genres = genres.map { it.name },
        id = id,
        title = originalTitle,
        overview = overview,
        posterPath = Constants.BASE_IMAGE_URL + posterPath,
        productionCountries = productionCountries.map { it.name },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages.joinToString(", ") { it.englishName },
        status = status,
        tagline = tagline,
        voteAverage = voteAverage
    )
}

fun MovieTopCast.Cast.toUiState(): MediaDetailsScreenUiState.MediaTopCastUiState {
    return MediaDetailsScreenUiState.MediaTopCastUiState(
        castId = id,
        castName = name,
        castImage = Constants.BASE_IMAGE_URL + profilePath
    )
}

fun MovieSimilar.Result.toUiState(): MediaDetailsScreenUiState.MovieSimilarUiState {
    return MediaDetailsScreenUiState.MovieSimilarUiState(
        mediaId = id,
        mediaName = title,
        mediaImage = Constants.BASE_IMAGE_URL + posterPath
    )
}

fun MovieReviews.Result.toUiState(): MediaDetailsScreenUiState.MediaReviewsUiState {
    return MediaDetailsScreenUiState.MediaReviewsUiState(
        reviewId = id,
        reviewAuthor = username,
        reviewDate = createdAt,
        reviewStars = rating,
        reviewDescription = content
    )
}

fun MovieRecommendations.Result.toUiState(): MediaDetailsScreenUiState.MediaRecommendationsUiState {
    return MediaDetailsScreenUiState.MediaRecommendationsUiState(
        mediaId = id,
        mediaName = title,
        mediaImage = Constants.BASE_IMAGE_URL + posterPath
    )
}

fun TvShowCast.toUiState(): MediaDetailsScreenUiState.MediaTopCastUiState {
    return MediaDetailsScreenUiState.MediaTopCastUiState(
        castId = id,
        castName = name,
        castImage = Constants.BASE_IMAGE_URL + image
    )
}

fun TvShowReview.toUiState(): MediaDetailsScreenUiState.MediaReviewsUiState {
    return MediaDetailsScreenUiState.MediaReviewsUiState(
        reviewAuthor = author,
        reviewDate = createdAt,
        reviewStars = rating,
        reviewDescription = content
    )
}

fun TvShowRecommendation.toUiState(): MediaDetailsScreenUiState.MediaRecommendationsUiState {
    return MediaDetailsScreenUiState.MediaRecommendationsUiState(
        mediaId = id,
        mediaName = seriesName,
        mediaImage = Constants.BASE_IMAGE_URL + poster
    )
}

fun SeasonTvShow.toUiState(): MediaDetailsScreenUiState.TVSeriesSeasonsUiState {
    return MediaDetailsScreenUiState.TVSeriesSeasonsUiState(
        posterSeason = Constants.BASE_IMAGE_URL + posterSeason,
        voteSeasonAverage = voteSeasonAverage,
        seasonNumber = seasonNumber.toString(),
        airDate = airDate,
        episodeNumber = episodeCount,
        seasonDescription = seasonDescription,
    )
}
