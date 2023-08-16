package com.redvelvet.ui.screen.movieDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.movieDetailsRoute() {
    composable(route = MovieDestination.MovieDetails.route) {
        MovieDetailsScreen()
    }
}

fun NavController.navigateToMovieDetails(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.MovieDetails.route, builder = builder)
}