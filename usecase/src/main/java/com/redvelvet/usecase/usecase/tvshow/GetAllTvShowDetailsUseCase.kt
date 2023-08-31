package com.redvelvet.usecase.usecase.tvshow

import com.redvelvet.entities.library.WatchListMedia
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.usecase.repository.TvShowRepository
import com.redvelvet.usecase.usecase.detailsActions.HandleItemCheckUsecase
import javax.inject.Inject

class GetAllTvShowDetailsUseCase @Inject constructor(
    private val repository: TvShowRepository,
    private val getActionsLists: HandleItemCheckUsecase,
) {
    suspend operator fun invoke(seriesId: Int): TvShowAllDetails {
        val recommendation = getTvShowRecommendations(seriesId).tvShowRecommendation
        val reviews = getTvShowReviews(seriesId).tvShowReviews
        val topCast = getTvShowTopCast(seriesId).cast
        val keywords = getTvShowKeywords(seriesId).tvShowKeywords
        val images = getTvShowImages(seriesId).posters
        val details = getTvShowDetails(seriesId)

        val tvFavorites = getTvFavorites()
        val tvWatchlist = getTvWatchlist()
        val ratedTv = getRatedTv()

        return TvShowAllDetails(
            tvShowId = details.tvShowId,
            tvShowName = details.tvShowName,
            tvShowImage = IMAGE_URL.plus(details.tvShowImage),
            keywords = keywords.map { it.name },
            firstAirDate = details.firstAirDate,
            genres = details.genres,
            posters = images.map { IMAGE_URL.plus(it.filePath) },
            recommendations = recommendation,
            reviews = reviews,
            topCast = topCast,
            voteAverage = details.voteAverage,
            tvShowDescription = details.tvShowDescription,
            tvShowLanguage = details.tvShowLanguage,
            seasons = details.seasons,
            tvShowTrailerUrl = VIDEO_URL.plus("watch?v=-MZ2My-6-Lc"),
            tvFavorites = tvFavorites,
            tvWatchlist = tvWatchlist,
            ratedTv = ratedTv,

            )
    }

    private suspend fun getTvShowDetails(seriesId: Int) = repository.getTvShowDetailsByID(seriesId)

    private suspend fun getTvShowImages(seriesId: Int) = repository.getTvShowImages(seriesId)

    private suspend fun getTvShowKeywords(seriesId: Int) =
        repository.getTvShowKeyWordsByID(seriesId)

    private suspend fun getTvShowRecommendations(seriesId: Int) =
        repository.getTvShowRecommendationsByID(seriesId)

    private suspend fun getTvShowReviews(seriesId: Int) = repository.getTvShowReviewsByID(seriesId)

    private suspend fun getTvShowTopCast(seriesId: Int) = repository.getTvShowTopCastByID(seriesId)

    suspend fun getTvFavorites(): WatchListMedia {
        return getActionsLists.getTvFavorites();
    }

    suspend fun getTvWatchlist(): WatchListMedia {
        return getActionsLists.getTvWatchList();
    }

    suspend fun getRatedTv(): WatchListMedia {
        return getActionsLists.getRatedTv();
    }


    companion object {
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        const val VIDEO_URL = "https://youtu.be/"
    }

}