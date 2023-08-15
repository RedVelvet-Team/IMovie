package com.redvelvet.ui.screen.tvshowdetails

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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.screen.tvshowdetails.mediaComposable.TvShowDetailsBackgroundContent
import com.redvelvet.ui.screen.tvshowdetails.mediaComposable.TvShowDetailsForegroundContent
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.tvshow.TvShowUiEffect
import com.redvelvet.viewmodel.tvshow.TvShowViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewTvShowDetailsScreen() {
    TvShowDetailsScreen()

}


@Composable
fun TvShowDetailsScreen(
    viewModel: TvShowViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    val navController = LocalNavController.current
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    var isScrolled by remember { mutableStateOf(false) }
    val state by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            viewModel.effect.collectLatest { effect ->
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
        }
    }
    if (state.isLoading && state.error == null) LoadingState()
    if (!state.isLoading && state.error != null) {
        Text(
            text = state.error.toString(),
            modifier = Modifier
                .fillMaxSize()
        )
    }
    if (!state.isLoading && state.error == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TvShowDetailsBackgroundContent(
                state.tvShowImage,
                viewModel,
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
