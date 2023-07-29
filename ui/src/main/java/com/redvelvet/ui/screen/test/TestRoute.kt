package com.redvelvet.ui.screen.test

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE_TESTING = "test"

fun NavGraphBuilder.testingRoute(navController: NavController) {
    composable(route = ROUTE_TESTING) {
        TestScreen(navController = navController)
    }
}