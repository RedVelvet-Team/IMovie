package com.redvelvet.ui.screen.tvshowdetails

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.DetailsInfoSection
import com.redvelvet.ui.composable.ImagesSection
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.TopCastSection
import com.redvelvet.ui.composable.MediaListSection
import com.redvelvet.ui.composable.ReviewsSection
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
                topcasts.map { it2 -> it2.image },
                topcasts.map { it2 -> it2.name })
        }
        KeyWordsSection(state.keywords)
        // TODO: ADD SEASIONS LIST
        // TvShowSeasonsSection(state.seasons, interaction)
        ImagesSection(state.posters, interaction::onClickPosterSeaAll)
        state.reviews.let { reviews ->
            ReviewsSection(
                isNotListEmpty = reviews.isNotEmpty(),
                reviewNames = reviews.map { it.author },
                reviewIds = reviews.map { it.id },
                reviewStars = reviews.map { it.rating },
                reviewDates = reviews.map { it.createdAt },
                reviewDescriptions = reviews.map { it.content },
                onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                onClickReview = interaction::onClickReview
            )
        }
        state.recommendations.let { recommendedTvShows ->
            MediaListSection(
                label = "Recommendations",
                isNotListEmpty = recommendedTvShows.isNotEmpty(),
                images = recommendedTvShows.map { it.poster },
                names = recommendedTvShows.map { it.seriesName },
                onClickSeeAll = interaction::onClickRecommendationsSeriesSeeAll,
                onClickItem = interaction::onClickRecommendation
            )
        }
    }
}
