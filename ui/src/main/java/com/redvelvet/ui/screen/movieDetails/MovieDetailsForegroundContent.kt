package com.redvelvet.ui.screen.movieDetails

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.DetailsInfoSection
import com.redvelvet.ui.composable.ImagesSection
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.MediaListSection
import com.redvelvet.ui.composable.ReviewsSection
import com.redvelvet.ui.composable.TopCastSection
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MovieDetailsForegroundContent(
    state: MovieDetailsScreenUiState,
    interaction: MovieDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    MediaDetailsForegroundContent(
        onScroll = onScroll
    ) {
        state.data?.let {
            it.details.let { det ->
                DetailsInfoSection(
                    image = det.posterPath,
                    id = det.id,
                    name = det.originalTitle,
                    genres = det.genres,
                    hasTime = true,
                    hasDate = false,
                    seriesDate = det.releaseDate,
                    spokenLanguages = det.spokenLanguages,
                    onClickGenre = interaction::onClickGenre,
                    onClickRate = interaction::onClickRateMovie,
                    voteAverage = det.voteAverage,
                    description = det.overview,
                )
            }

            it.topCast.let { topcasts ->
                TopCastSection(
                    topcasts.isNotEmpty(),
                    interaction::onClickTopCastSeeAll,
                    interaction::onClickCast,
                    castIds = topcasts.map { it2 -> it2.castId },
                    topcasts.map { it2 -> it2.castImage },
                    topcasts.map { it2 -> it2.castName })
            }
            MovieDetailsMoreInfoSection(it.details)
            KeyWordsSection(it.keyWords)
            it.similar.let { similarMovies ->
                MediaListSection(
                    label = "Similar Movies",
                    isNotListEmpty = similarMovies.isNotEmpty(),
                    images = similarMovies.map { it.mediaImage },
                    names = similarMovies.map { it.mediaName },
                    movieIds = similarMovies.map { it.mediaId },
                    onClickSeeAll = interaction::onClickSimilarMoviesSeeAll,
                    onClickItem = interaction::onClickMovie
                )
            }
            ImagesSection(it.images.map { it.mediaImage }, interaction::onClickMovieImagesSeeAll)
            it.reviews.let { reviews ->
                ReviewsSection(
                    isNotListEmpty = reviews.isNotEmpty(),
                    reviewNames = reviews.map { it.reviewAuthor },
                    reviewIds = reviews.map { it.reviewId },
                    reviewStars = reviews.map { it.reviewStars },
                    reviewDates = reviews.map { it.reviewDate },
                    reviewDescriptions = reviews.map { it.reviewDescription },
                    onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                    onClickReview = interaction::onClickReview
                )
            }
            it.recommendations.let { recommendedMovies ->
                MediaListSection(
                    label = "Recommendations",
                    isNotListEmpty = recommendedMovies.isNotEmpty(),
                    images = recommendedMovies.map { it.mediaImage },
                    names = recommendedMovies.map { it.mediaName },
                    movieIds = recommendedMovies.map { it.mediaId },
                    onClickSeeAll = interaction::onClickRecommendationsMoviesSeeAll,
                    onClickItem = interaction::onClickMovie
                )
            }
        }
    }
}

