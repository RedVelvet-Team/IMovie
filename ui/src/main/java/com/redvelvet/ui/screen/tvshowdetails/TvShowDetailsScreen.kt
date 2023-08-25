package com.redvelvet.ui.screen.tvshowdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.MediaDetailsBackgroundContent
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.screen.actor_details.navigateToActorDetails
import com.redvelvet.ui.screen.seeAllMovieImages.navigateToSeeAllImages
import com.redvelvet.ui.screen.seeAllReviews.navigateToSeeAllReviews
import com.redvelvet.ui.screen.seeallseasons.navigateToSeasonDetails
import com.redvelvet.ui.screen.seealltv.navigateSeeAllTvShow
import com.redvelvet.ui.screen.sellAllTopCast.navigateToSeeAllTopCast
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.tvshow.TvShowUiEffect
import com.redvelvet.viewmodel.tvshow.TvShowViewModel
import com.redvelvet.viewmodel.utils.SeeAllTvShows

@Composable
fun TvShowDetailsScreen(
    viewModel: TvShowViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    var isScrolled by remember { mutableStateOf(false) }
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is TvShowUiEffect.NavigateToSeasonDetailsScreen -> navController.navigateToSeeAllEpisode(effect.id, effect.seasonId.toString())
                is TvShowUiEffect.NavigateToSeasonSeeAllScreen -> navController.navigateToSeasonDetails(
                    effect.id
                )

                is TvShowUiEffect.NavigateToTvShowPosterSeeAllScreen -> navController.navigateToSeeAllImages()
                is TvShowUiEffect.NavigateToTvShowRecommendationSeeAllScreen -> navController.navigateSeeAllTvShow(
                    effect.id,
                    SeeAllTvShows.RECOMMEND
                )

                is TvShowUiEffect.NavigateToTopCastSeeAllScreen -> navController.navigateToSeeAllTopCast(
                    id = effect.id
                )

                is TvShowUiEffect.NavigateToActorDetailsScreen -> navController.navigateToActorDetails(
                    effect.id
                )

                is TvShowUiEffect.NavigateToReviewSeeAllScreen -> navController.navigateToSeeAllReviews(
                    effect.id
                )

                else -> {}
            }
        }
    )
    FlixMovieScaffold(
        isLoading = state.isLoading,
        error = state.error,
        onClick = viewModel::refresh
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MediaDetailsBackgroundContent(
                state.tvShowImage,
                viewModel::onClickPlayTrailer,
                state.tvShowTrailerUrl
            )
            TvShowDetailsForegroundContent(state, viewModel) { offset ->
                isScrolled = offset > 1000
            }
            CustomMediaDetailsTopAppBar(
                onBackClicked = { navController.popBackStack() },
                onFavoriteClicked = { viewModel.onClickFavorite(state.tvShowId) },
                onSaveClicked = { viewModel.onClickSave(state.tvShowId) },
                isScrolled = isScrolled
            )
        }
    }

}
