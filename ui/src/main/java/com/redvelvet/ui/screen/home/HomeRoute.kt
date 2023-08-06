package com.redvelvet.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.homeRoute() {
    composable(route = MovieDestination.Home.route) {
        HomeScreen()
    }
}

fun NavController.navigateToHome() {
    navigate(MovieDestination.Home.route, androidx.navigation.navOptions {
        popUpTo(MovieDestination.Splash.route) {
            inclusive = true
        }
    })
}