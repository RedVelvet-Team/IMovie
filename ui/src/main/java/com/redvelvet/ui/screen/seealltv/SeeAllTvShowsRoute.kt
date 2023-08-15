package com.redvelvet.ui.screen.seealltv

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllTvListRoute() {
    composable(route = MovieDestination.SeeAllTvShow.route) {
        SeeAllTvScreen()
    }
}

fun NavController.navigateSeeAllMovie(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllTvShow.route, builder = builder)
}