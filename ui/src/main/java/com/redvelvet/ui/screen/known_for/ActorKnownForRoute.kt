package com.redvelvet.ui.screen.known_for

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.knownFor.KnownForArgs

private val ROUTE = MovieDestination.ActorKnownFor.route
fun NavGraphBuilder.actorKnownForRoute(navController: NavHostController) {
    composable(
        route ="$ROUTE/{${KnownForArgs.ID}}",
        arguments = listOf(
            navArgument(KnownForArgs.ID) { NavType.StringType }
        )
    ) {
        ActorKnownForScreen(navController = navController)
    }
}

fun NavController.navigateToActorKnownFor(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "$ROUTE/${id}", builder = builder)
}
