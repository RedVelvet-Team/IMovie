package com.redvelvet.ui.screens.boarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE_BOARDING = "boarding"

fun NavGraphBuilder.boardingRoute(navController: NavController){
    composable(route = ROUTE_BOARDING){
        BoardingScreen(navController = navController)
    }
}