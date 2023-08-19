package com.redvelvet.ui.screen.movie_player

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.movie_player.MoviePlayerArgs

private val ROUTE = MovieDestination.MoviePlayer.route

fun NavGraphBuilder.moviePlayerRoute() {
    composable(
        route = "$ROUTE/${MoviePlayerArgs.PRODUCTION_CODE}",
        arguments = listOf(navArgument(MoviePlayerArgs.PRODUCTION_CODE) { NavType.StringType })
    ) {
        MoviePlayer()
    }
}

fun NavController.navigateMoviePlayer(movieId:String,builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(
        route = "$ROUTE/${movieId}",
        builder = builder
    )
}