package com.redvelvet.ui.screen.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.onBoardingRoute() {
    composable(route = MovieDestination.OnBoarding.route) {
        OnBoardingScreen()
    }
}

fun NavController.navigateToOnBoarding(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.OnBoarding.route, builder)
}