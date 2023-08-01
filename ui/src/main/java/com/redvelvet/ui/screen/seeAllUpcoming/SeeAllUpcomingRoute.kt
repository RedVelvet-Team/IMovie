package com.redvelvet.ui.screen.seeAllUpcoming

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllUpcomingListRoute(navController: NavController) {
    composable(route = MovieDestination.SeeAllUpcoming.route) {
        SeeAllUpcomingListScreen(navController = navController)
    }
}

fun NavController.navigateSeeAllUpcoming(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllUpcoming.route, builder = builder)
}