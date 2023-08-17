package com.redvelvet.ui.screen.seeAllMovieImages

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.seeAllMovieImaesRoute() {
    composable(route = MovieDestination.SeeAllMovieImages.route) {
        SeeAllMovieImaesScreen()
    }
}

fun NavController.navigateToSeeAllImages(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllMovieImages.route, builder = builder)
}