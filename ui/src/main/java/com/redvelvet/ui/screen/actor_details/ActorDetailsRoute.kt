package com.redvelvet.ui.screen.actor_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.actorDetailsRoute() {
    composable(route = MovieDestination.ActorDetails.route) {
        ActorDetailsScreen()
    }
}

fun NavController.navigateToActorDetails(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.ActorDetails.route, builder)
}