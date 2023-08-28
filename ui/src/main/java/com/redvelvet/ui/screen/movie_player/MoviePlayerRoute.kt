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
        route = "$ROUTE /{${MoviePlayerArgs.VIDEO_URL}}/{${MoviePlayerArgs.ROOM_URL}}",
        arguments = listOf(
            navArgument(MoviePlayerArgs.VIDEO_URL) {
                NavType.StringType
                nullable = true
            },
            navArgument(MoviePlayerArgs.ROOM_URL) {
                NavType.StringType
                nullable = true
            },
        )
    ) {
        MoviePlayerScreen()
    }
}

fun NavController.navigateMoviePlayer(
    movieUrl: String ?= null,
    roomUrl: String?= null,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(
        route = "$ROUTE/${movieUrl}/${roomUrl}",
        builder = builder
    )
}