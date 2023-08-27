package com.redvelvet.ui.screen.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.splashRoute() {
    composable(route = MovieDestination.Splash.route) {
        SplashScreen()
    }
}