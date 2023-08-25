package com.redvelvet.ui.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.gameScreenRoute() {
    composable(route = MovieDestination.Game.route) {
        GameScreen()
    }
}

fun NavController.navigateToGameScreen(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Game.route, builder)
}