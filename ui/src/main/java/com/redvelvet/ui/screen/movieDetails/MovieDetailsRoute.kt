package com.redvelvet.ui.screen.movieDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.movieDetails.MovieDetailsArgs
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieArgs

private val ROUTE = MovieDestination.MovieDetails.route

fun NavGraphBuilder.movieDetailsRoute() {
    composable(
        route = "${ROUTE}/{${MovieDetailsArgs.ID}}",
        arguments = listOf(
            navArgument(SeeAllMovieArgs.ID) {
                type = NavType.StringType
            }
        )
    ) {
        MovieDetailsScreen()
    }
}

fun NavController.navigateToMovieDetails(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}", builder = builder)
}