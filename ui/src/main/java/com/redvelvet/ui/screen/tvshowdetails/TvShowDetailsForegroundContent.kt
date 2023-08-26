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
import com.redvelvet.ui.screen.movieDetails.Item
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
                items = topcasts.map { it2 ->
                    Item(
                        id = it2.id,
                        image = it2.image,
                        name = it2.name,
                    )
                },
                mediaId = state.tvShowId.toString(),
            )
        }
        KeyWordsSection(state.keywords)
        state.seasons.let { seasons ->
            Log.i("seasons", "seasons $seasons");
            SeasonsSection(
                isNotListEmpty = seasons.isNotEmpty(),
                seriesId = state.tvShowId,
                items = seasons.map {
                    Item(
                        image = it.posterSeason,
                        name = it.seasonNumber,
                        id = it.seasonId,
                        stars = it.voteSeasonAverage,
                        date = it.airDate,
                        discription = it.seasonDescription,
                        episodeNum = it.episodeNumber,
                    )
                },
                onClickSeeAllSeasons = interaction::onClickSeasonSeaAll,
                onClickSeason = interaction::onClickSeason
            )
        }
        ImagesSection(
            items = state.posters.map { Item(image = it) },
            interaction::onClickPosterSeaAll,
            mediaId = state.tvShowId
        )
        state.reviews.let { reviews ->
            ReviewsSection(
                isNotListEmpty = reviews.isNotEmpty(),
                items = reviews.map {
                    Item(
                        name = it.author,
                        id = it.id.toInt(),
                        stars = it.rating,
                        date = it.createdAt,
                        discription = it.content,
                    )
                },
                onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                itemId = state.tvShowId.toString()
            )
        }
        state.recommendations.let { recommendedTvShows ->
            MediaListSection(
                label = "Recommendations",
                isNotListEmpty = recommendedTvShows.isNotEmpty(),
                items = recommendedTvShows.map { Item(image = it.poster, name = it.seriesName) },
                onClickSeeAll = interaction::onClickRecommendationsSeriesSeeAll,
                onClickItem = interaction::onClickSeries,
                mediaId = state.tvShowId
            )
        }
    }
}
