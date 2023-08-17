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
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.composable.MediaDetailsBackgroundContent
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.tvshow.TvShowUiEffect
import com.redvelvet.viewmodel.tvshow.TvShowViewModel

@Composable
fun TvShowDetailsScreen(
    viewModel: TvShowViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    var isScrolled by remember { mutableStateOf(false) }
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                // TODO: DO NOT FORGET OT CHANGE THE NAVIGATIONS
                TvShowUiEffect.NavigateToSeasonDetailsScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToSeasonSeeAllScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowPosterSeeAllScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowRecommendationDetailsScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowRecommendationSeeAllScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowReviewDetailsScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowReviewSeeAllScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateToTvShowTopCastDetailsScreen -> navController.navigateToTvShowDetails()
                TvShowUiEffect.NavigateTvShowToTopCastSeeAllScreen -> navController.navigateToTvShowDetails()
                else -> {}
            }
        }
    )
    MovieScaffold(
        isLoading = state.isLoading,
        error = state.error
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
                // TODO: HANDLE THESE INTERACTIONS
                onBackClicked = { /* Handle back clicked */ },
                onFavoriteClicked = { /* Handle favorite clicked */ },
                onSaveClicked = { /* Handle save clicked */ },
                isScrolled = isScrolled
            )
        }
    }

}
