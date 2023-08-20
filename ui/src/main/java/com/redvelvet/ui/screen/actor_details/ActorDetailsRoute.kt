package com.redvelvet.ui.screen.actor_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.actor_details.ActorDetailsArgs
import com.redvelvet.viewmodel.utils.SeeAllMovie

private val ROUTE = MovieDestination.ActorDetails.route

fun NavGraphBuilder.actorDetailsRoute() {
    composable(
        route = "$ROUTE/{${ActorDetailsArgs.ID}}",
        arguments = listOf(
            navArgument(ActorDetailsArgs.ID) { NavType.StringType }
        )
    ) {
        ActorDetailsScreen()
    }
}

fun NavController.navigateToActorDetails(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}", builder = builder)
}