package com.redvelvet.ui.screen.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable(route = MovieDestination.Splash.route) {
        SplashScreen(navController = navController)
    }
}