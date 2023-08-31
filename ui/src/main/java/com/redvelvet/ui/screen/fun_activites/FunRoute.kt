package com.redvelvet.ui.screen.fun_activites

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

private val ROUTE = MovieDestination.FunActivities.route
fun NavGraphBuilder.funActivitiesRoute() {
    composable(route = ROUTE) { FunScreen() }
}

fun NavController.navigateToFunActivities(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(ROUTE, builder = builder)
}