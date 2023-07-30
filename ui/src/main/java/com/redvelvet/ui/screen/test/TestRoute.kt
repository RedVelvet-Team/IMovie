package com.redvelvet.ui.screen.test

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.testingRoute(navController: NavController) {
    composable(route = MovieDestination.Testing.route) {
        TestScreen(navController = navController)
    }
}