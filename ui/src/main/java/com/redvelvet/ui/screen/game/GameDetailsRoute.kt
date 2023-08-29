package com.redvelvet.ui.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.gameDetailsScreen() {
    composable(route = MovieDestination.GameDetails.route) {
        GameDetailsScreen()
    }
}

fun NavController.navigateToGameDetailsScreen(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.GameDetails.route, builder)
}