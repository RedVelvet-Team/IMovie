package com.redvelvet.ui.screen.sellAllTopCast

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.movie_details_seeall.TopCastArgs

private val ROUTE = MovieDestination.SeeAllTopCast.route

fun NavGraphBuilder.seeAllTopCastRoute() {
    composable(
        route = "$ROUTE/{${TopCastArgs.ID}}",
        arguments = listOf(
            navArgument(TopCastArgs.ID) { NavType.StringType }
        )
    ) {
        SeeAllTopCastScreen()
    }
}

fun NavController.navigateToSeeAllTopCast(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}", builder = builder)
}