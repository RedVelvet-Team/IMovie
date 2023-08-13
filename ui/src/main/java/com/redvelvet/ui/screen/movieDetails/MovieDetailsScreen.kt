package com.redvelvet.ui.screen.movieDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsBackgroundContent
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsForegroundContent
import com.redvelvet.ui.screen.seeAllUpcoming.navigateSeeAllUpcoming
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.movieDetails.MovieDetailsUiEvent
import com.redvelvet.viewmodel.movieDetails.MovieDetailsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewMovieDetailsScreen() {
    MovieDetailsScreen(rememberNavController())

}


@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    var isScrolled by remember { mutableStateOf(false) }
    val state by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            viewModel.event.collectLatest { event ->
                when (event) {
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
        }
    }
    if (state.isLoading && !state.isError.first) LoadingState()
    if (!state.isLoading && state.isError.first) {
        Text(
            text = state.isError.second,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    if (!state.isLoading && !state.isError.first) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            state.data?.details?.let {
                MediaDetailsBackgroundContent(
                    "${state.data?.details?.posterPath}",
                    viewModel,
                    it.homepage
                )
            }
            MediaDetailsForegroundContent(state, viewModel) { offset ->
                isScrolled = offset > 790
            }
            CustomMediaDetailsTopAppBar(
                onBackClicked = { /* Handle back clicked */ },
                onFavoriteClicked = { /* Handle favorite clicked */ },
                onSaveClicked = { /* Handle save clicked */ },
                isScrolled = isScrolled
            )
        }
    }
}
