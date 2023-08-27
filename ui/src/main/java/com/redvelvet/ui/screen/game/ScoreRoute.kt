package com.redvelvet.ui.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.gameScoreRoute() {
    composable(route = MovieDestination.GameScore.route) {
        ScoreScreen()
    }
}

fun NavController.navigateToGameScoreScreen(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.GameScore.route, builder)
}