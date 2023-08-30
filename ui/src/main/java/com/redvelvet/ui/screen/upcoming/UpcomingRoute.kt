package com.redvelvet.ui.screen.upcoming

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

private val ROUTE = MovieDestination.SeeAllEpisodes.route

fun NavGraphBuilder.upcomingRoute() {
    composable(route = MovieDestination.Upcoming.route) {
        ComingScreen()
    }
}
fun NavController.navigateToUpcoming(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = ROUTE, builder = builder)
}
