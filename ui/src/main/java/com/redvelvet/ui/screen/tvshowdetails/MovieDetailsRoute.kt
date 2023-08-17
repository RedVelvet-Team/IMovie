package com.redvelvet.ui.screen.tvshowdetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.tvShowDetailsRoute() {
    composable(route = MovieDestination.TvShowDetails.route) {
        TvShowDetailsScreen()
    }
}

fun NavController.navigateToTvShowDetails(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.TvShowDetails.route, builder = builder)
}
