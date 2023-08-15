package com.redvelvet.ui.screen.known_for

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.actorKnownForRoute() {
    composable(route = MovieDestination.ActorKnownFor.route) {
        ActorKnownForScreen()
    }
}

fun NavController.navigateToActorKnownFor(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.ActorKnownFor.route, builder = builder)
}