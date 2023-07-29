package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redvelvet.ui.screen.splash.SplashScreen

@Composable
fun MovieNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieDestination.Splash.route) {
        composable(MovieDestination.Splash.route) { SplashScreen(navController = navController) }
    }
}