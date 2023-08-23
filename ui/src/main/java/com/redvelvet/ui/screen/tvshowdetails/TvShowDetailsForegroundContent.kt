package com.redvelvet.ui.screen.tvshowdetails

import android.util.Log
import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.DetailsInfoSection
import com.redvelvet.ui.composable.ImagesSection
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.TopCastSection
import com.redvelvet.ui.composable.MediaListSection
import com.redvelvet.ui.composable.ReviewsSection
import com.redvelvet.ui.composable.SeasonsSection
import com.redvelvet.viewmodel.tvshow.SeriesDetailsUiState
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsForegroundContent(
    state: SeriesDetailsUiState,
    interaction: TvShowDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    MediaDetailsForegroundContent(
        onScroll = onScroll
    ) {
        DetailsInfoSection(
            image = state.tvShowImage,
            id = state.tvShowId,
            name = state.tvShowName,
            genres = state.genres,
            hasTime = false,
            hasDate = true,
            seriesDate = state.firstAirDate,
            spokenLanguages = state.tvShowLanguage,
            onClickGenre = interaction::onClickCategory,
            onClickRate = interaction::onClickRateSeries,
            voteAverage = state.voteAverage,
            description = state.tvShowDescription,
        )
        state.topCast.let { topcasts ->
            TopCastSection(
                topcasts.isNotEmpty(),
                interaction::onClickTopCastSeeAll,
                interaction::onClickCast,
                castIds = topcasts.map { it2 -> it2.id },
                topcasts.map { it2 -> it2.image },
                topcasts.map { it2 -> it2.name },
                mediaId = state.tvShowId.toString(),
            )
        }
        KeyWordsSection(state.keywords)
        state.seasons.let { seasons ->
            Log.i("seasons", "seasons $seasons");
            SeasonsSection(
                isNotListEmpty = seasons.isNotEmpty(),
                seriesId = state.tvShowId,
                seasonImages = seasons.map { it.posterSeason },
                seasonNames = seasons.map { it.seasonNumber },
                seasonIds = seasons.map { it.seasonId },
                seasonStars = seasons.map { it.voteSeasonAverage },
                seasonDates = seasons.map { it.airDate },
                seasonDescriptions = seasons.map { it.seasonDescription },
                seasonEpisodes = seasons.map { it.episodeNumber },
                onClickSeeAllSeasons = interaction::onClickSeasonSeaAll,
                onClickSeason = interaction::onClickSeason
            )
        }
        ImagesSection(
            state.posters,
            interaction::onClickPosterSeaAll,
            mediaId = state.tvShowId
        )
        state.reviews.let { reviews ->
            ReviewsSection(
                isNotListEmpty = reviews.isNotEmpty(),
                reviewNames = reviews.map { it.author },
                reviewIds = reviews.map { it.id },
                reviewStars = reviews.map { it.rating },
                reviewDates = reviews.map { it.createdAt },
                reviewDescriptions = reviews.map { it.content },
                onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                onClickReview = interaction::onClickReview,
                itemId = state.tvShowId.toString()
            )
        }
        state.recommendations.let { recommendedTvShows ->
            MediaListSection(
                label = "Recommendations",
                isNotListEmpty = recommendedTvShows.isNotEmpty(),
                images = recommendedTvShows.map { it.poster },
                names = recommendedTvShows.map { it.seriesName },
                onClickSeeAll = interaction::onClickRecommendationsSeriesSeeAll,
                onClickItem = interaction::onClickSeries,
                mediaId = state.tvShowId
            )
        }
    }
}
