package com.redvelvet.ui.screen.seeall

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllMovieListRoute() {
    composable(route = MovieDestination.SeeAllMovie.route) {
        SeeAllMovieScreen()
    }
}

fun NavController.navigateSeeAllMovie(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllMovie.route, builder = builder)
}