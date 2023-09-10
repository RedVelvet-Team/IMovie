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
import com.redvelvet.viewmodel.details_ui_states.MediaDetailsScreenUiState
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsForegroundContent(
    state: MediaDetailsScreenUiState,
    interaction: TvShowDetailsInteraction,
    isRated: Boolean,
    onScroll: (offset: Int) -> Unit,
) {
    MediaDetailsForegroundContent(
        onScroll = onScroll
    ) {
        state.data?.let {
            it.details.let { det ->
                DetailsInfoSection(
                    image = det.posterPath,
                    id = det.id,
                    name = det.title,
                    genres = det.genres,
                    hasTime = true,
                    hasDate = false,
                    seriesDate = det.releaseDate,
                    spokenLanguages = det.spokenLanguages,
                    onClickGenre = interaction::onClickCategory,
                    onClickRate = interaction::onClickRateSeries,
                    voteAverage = det.voteAverage,
                    description = det.overview,
                    isRated = isRated,
                    mediaType = "Tv Show"
                )
            }
            it.topCast.let { topcasts ->
                TopCastSection(
                    topcasts.isNotEmpty(),
                    interaction::onClickTopCastSeeAll,
                    interaction::onClickCast,
                    items = topcasts.map { it2 ->
                        Item(
                            image = it2.castImage,
                            name = it2.castName,
                            id = it2.castId,
                        )
                    },
                    mediaId = state.data!!.details.id.toString()
                )
            }
            KeyWordsSection(it.keyWords)
            it.tvSeasons.let { seasons ->
                Log.i("seasons", "seasons $seasons");
                SeasonsSection(
                    isNotListEmpty = seasons.isNotEmpty(),
                    seriesId = it.details.id,
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
                items = it.images.map { Item(image = it) },
                interaction::onClickPosterSeaAll,
                mediaId = it.details.id
            )
            it.reviews.let { reviews ->
                ReviewsSection(
                    isNotListEmpty = reviews.isNotEmpty(),
                    items = reviews.map {
                        Item(
                            name = it.reviewAuthor,
                            id = it.reviewId.toInt(),
                            stars = it.reviewStars,
                            date = it.reviewDate,
                            discription = it.reviewDescription,
                        )
                    },
                    onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                    itemId = it.details.id.toString()
                )
            }
            it.recommendations.let { recommendedTvShows ->
                MediaListSection(
                    label = "Recommendations",
                    isNotListEmpty = recommendedTvShows.isNotEmpty(),
                    items = recommendedTvShows.map {
                        Item(
                            image = it.mediaImage,
                            name = it.mediaName
                        )
                    },
                    onClickSeeAll = interaction::onClickRecommendationsSeriesSeeAll,
                    onClickItem = interaction::onClickSeries,
                    mediaId = it.details.id
                )
            }

        }
    }
}
