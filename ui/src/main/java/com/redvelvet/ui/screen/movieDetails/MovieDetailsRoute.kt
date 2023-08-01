package com.redvelvet.ui.screen.movieDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.movieDetailsRoute(navController: NavController) {
    composable(route = MovieDestination.MovieDetails.route) {
        MovieDetailsScreen(navController = navController)
    }
}

fun NavController.navigateToMovieDetails(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.MovieDetails.route, builder = builder)
}