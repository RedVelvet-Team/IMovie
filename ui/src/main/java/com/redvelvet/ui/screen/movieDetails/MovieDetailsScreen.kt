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
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.composable.MediaDetailsBackgroundContent
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.screen.actor_details.navigateToActorDetails
import com.redvelvet.ui.screen.seeall.navigateToSeeAllMovie
import com.redvelvet.ui.screen.sellAllTopCast.navigateToSeeAllTopCast
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEffect
import com.redvelvet.viewmodel.movieDetails.MovieDetailsViewModel
import com.redvelvet.viewmodel.utils.SeeAllMovie

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    var isScrolled by remember { mutableStateOf(false) }
    val systemUiController = rememberSystemUiController()
    val navController = LocalNavController.current
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is MovieDetailsUiEffect.NavigateToGenreScreen -> {}
                is MovieDetailsUiEffect.NavigateToMovieImagesSeeAllScreen -> {}
                is MovieDetailsUiEffect.NavigateToReviewDetailsScreen -> {}
                is MovieDetailsUiEffect.NavigateToReviewSeeAllScreen -> {}
                is MovieDetailsUiEffect.NavigateToMovieDetailsScreen -> navController.navigateToMovieDetails(
                    effect.id
                )

                is MovieDetailsUiEffect.NavigateToSimilarMoviesSeeAllScreen -> navController.navigateToSeeAllMovie(
                    "",
                    SeeAllMovie.SIMILAR
                )

                is MovieDetailsUiEffect.NavigateToRecommendedMoviesSeeAllScreen -> navController.navigateToSeeAllMovie(
                    "",
                    SeeAllMovie.RECOMMEND
                )

                is MovieDetailsUiEffect.NavigateToTopCastDetailsScreen -> navController.navigateToActorDetails(
                    effect.id
                )

                is MovieDetailsUiEffect.NavigateToTopCastSeeAllScreen -> navController.navigateToSeeAllTopCast()
            }
        }
    )
    MovieScaffold(
        isLoading = state.isLoading,
        error = state.error,
        onClick = viewModel::refresh
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
                onBackClicked = { navController.popBackStack() },
                onFavoriteClicked = { /* Handle favorite clicked */ },
                onSaveClicked = { /* Handle save clicked */ },
                isScrolled = isScrolled
            )
        }

    }
}