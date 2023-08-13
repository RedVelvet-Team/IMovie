package com.redvelvet.ui.screen.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.onBoardingRoute() {
    composable(route = MovieDestination.OnBoarding.route) {
        OnBoardingScreen()
    }
}

fun NavController.navigateToOnBoarding() {
    navigate(MovieDestination.OnBoarding.route, navOptions {
        popUpTo(MovieDestination.Splash.route) {
            inclusive = true
        }
    })
}