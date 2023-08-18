package com.redvelvet.ui.screen.sellAllTopCast

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllTopCastRoute() {
    composable(route = MovieDestination.SeeAllTopCast.route) {
        SeeAllTopCastScreen()
    }
}

fun NavController.navigateToSeeAllTopCast(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllTopCast.route, builder = builder)
}