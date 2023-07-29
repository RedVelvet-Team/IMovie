package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.screen.onboarding.onBoardingRoute
import com.redvelvet.ui.screen.splash.splashRoute

@Composable
fun MovieNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieDestination.Splash.route) {
        splashRoute(navController)
        onBoardingRoute(navController)
    }
}