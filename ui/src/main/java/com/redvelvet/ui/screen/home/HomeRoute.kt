package com.redvelvet.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.homeRoute() {
    composable(route = MovieDestination.Home.route) {
        HomeScreen()
    }
}

fun NavController.navigateToHome(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Home.route, builder = builder)
}