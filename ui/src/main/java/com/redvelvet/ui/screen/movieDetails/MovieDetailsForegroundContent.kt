package com.redvelvet.ui.screen.movieDetails

import androidx.compose.runtime.Composable
import com.redvelvet.ui.composable.DetailsInfoSection
import com.redvelvet.ui.composable.ImagesSection
import com.redvelvet.ui.composable.KeyWordsSection
import com.redvelvet.ui.composable.MediaDetailsForegroundContent
import com.redvelvet.ui.composable.MediaListSection
import com.redvelvet.ui.composable.ReviewsSection
import com.redvelvet.ui.composable.TopCastSection
import com.redvelvet.viewmodel.details_ui_states.MediaDetailsScreenUiState
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction

@Composable
fun MovieDetailsForegroundContent(
    state: MediaDetailsScreenUiState,
    interaction: MovieDetailsInteraction,
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
                    onClickGenre = interaction::onClickGenre,
                    onClickRate = interaction::onClickRateMovie,
                    voteAverage = det.voteAverage,
                    description = det.overview,
                    isRated = isRated,
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
            MovieDetailsMoreInfoSection(
                it.details.productionCountries,
                it.details.status,
                it.details.releaseDate
            )
            KeyWordsSection(it.keyWords)
            it.similar.let { similarMovies ->
                MediaListSection(
                    label = "Similar Movies",
                    isNotListEmpty = similarMovies.isNotEmpty(),
                    items = similarMovies.map { it ->
                        Item(
                            image = it.mediaImage,
                            id = it.mediaId,
                            name = it.mediaName,
                        )
                    },
                    onClickSeeAll = interaction::onClickSimilarMoviesSeeAll,
                    onClickItem = interaction::onClickMovie,
                    mediaId = state.data!!.details.id
                )
            }
            ImagesSection(
                items = it.images.map { Item(image = it) },
                interaction::onClickMovieImagesSeeAll,
                mediaId = it.details.id
            )
            it.reviews.let { reviews ->
                ReviewsSection(
                    isNotListEmpty = reviews.isNotEmpty(),
                    items = reviews.map { it2 ->
                        Item(
                            name = it2.reviewAuthor,
                            strId = it2.reviewId,
                            stars = it2.reviewStars,
                            date = it2.reviewDate,
                            discription = it2.reviewDescription,
                        )
                    },
                    onClickSeeAllReviews = interaction::onClickReviewsSeeAll,
                    onClickReview = interaction::onClickReview,
                    itemId = it.details.id.toString()
                )
            }
            it.recommendations.let { recommendedMovies ->
                MediaListSection(
                    label = "Recommendations",
                    isNotListEmpty = recommendedMovies.isNotEmpty(),
                    items = recommendedMovies.map { it2 ->
                        Item(
                            image = it2.mediaImage,
                            name = it2.mediaName,
                            id = it2.mediaId,
                        )
                    },
                    onClickSeeAll = interaction::onClickRecommendationsMoviesSeeAll,
                    onClickItem = interaction::onClickMovie,
                    mediaId = state.data!!.details.id
                )
            }
        }
    }
}

