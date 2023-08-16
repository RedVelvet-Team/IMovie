package com.redvelvet.ui.screen.movieDetails

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
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.StateHandler
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MovieDetailsForegroundContent
import com.redvelvet.ui.screen.seeAllUpcoming.navigateSeeAllUpcoming
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEvent
import com.redvelvet.viewmodel.movieDetails.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    var isScrolled by remember { mutableStateOf(false) }
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                // TODO: DO NOT FORGET OT CHANGE THE NAVIGATIONS AND NAME OF UIEVENT INTO UIEFFECT
                MovieDetailsUiEvent.NavigateToGenreScreen -> navController.navigateToMovieDetails()
                MovieDetailsUiEvent.NavigateToMovieDetailsScreen -> navController.navigateToMovieDetails()
                MovieDetailsUiEvent.NavigateToMovieImagesSeeAllScreen -> navController.navigateSeeAllUpcoming()
                MovieDetailsUiEvent.NavigateToMoviesSeeAllScreen -> navController.navigateSeeAllUpcoming()
                MovieDetailsUiEvent.NavigateToReviewDetailsScreen -> navController.navigateToMovieDetails()
                MovieDetailsUiEvent.NavigateToReviewSeeAllScreen -> navController.navigateSeeAllUpcoming()
                MovieDetailsUiEvent.NavigateToTopCastDetailsScreen -> navController.navigateToMovieDetails()
                MovieDetailsUiEvent.NavigateToTopCastSeeAllScreen -> navController.navigateSeeAllUpcoming()
            }
        }
    )
    StateHandler(
        isLoading = state.isLoading,
        isError = state.isError.first
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            state.data?.details?.let {
                MediaDetailsBackgroundContent(
                    "${state.data?.details?.posterPath}",
                    viewModel::onClickPlayTrailer,
                    it.homepage
                )
            }

            MovieDetailsForegroundContent(state, viewModel) { offset ->
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




