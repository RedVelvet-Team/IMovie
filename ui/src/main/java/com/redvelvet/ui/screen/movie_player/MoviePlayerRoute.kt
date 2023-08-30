package com.redvelvet.ui.screen.movie_player

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.tvshowdetails.TvShowDetailsScreen
import com.redvelvet.viewmodel.movie_player.MoviePlayerArgs
import com.redvelvet.viewmodel.seeall.tv.SeeAllTvArgs
import com.redvelvet.viewmodel.tvshow.TvDetailsArgs

private val ROUTE = MovieDestination.MoviePlayer.route

fun NavGraphBuilder.moviePlayerRoute() {
    composable(
        route = ROUTE,
            )
    {
        MoviePlayerScreen()
    }
}

fun NavController.navigateMoviePlayer(
//    movieUrl: String ?= null,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(
        route = ROUTE,
        builder = builder
    )
}





