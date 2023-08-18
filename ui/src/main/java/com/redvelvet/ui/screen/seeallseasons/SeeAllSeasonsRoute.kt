package com.redvelvet.ui.screen.seeallseasons

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.actor_details.ActorDetailsScreen
import com.redvelvet.viewmodel.seeall.seasons.SeasonDetailsArgs

private val ROUTE = MovieDestination.SeeAllSeasons.route

fun NavGraphBuilder.seeAllSeasonsRoute() {
    composable(
        route = "${ROUTE}/{${SeasonDetailsArgs.ID}}",
        arguments = listOf(
            navArgument(SeasonDetailsArgs.ID) { NavType.StringType }
        )
    ) {
        SeeAllSeasonsScreen()
    }
}

fun NavController.navigateToSeasonDetails(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "$ROUTE/${id}", builder = builder)
}