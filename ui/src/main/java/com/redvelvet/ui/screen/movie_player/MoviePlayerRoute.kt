package com.redvelvet.ui.screen.movie_player

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.youtube_player.YoutubePlayerArgs

private val ROUTE = MovieDestination.MoviePlayer.route

fun NavGraphBuilder.moviePlayerRoute() {
    composable(
        route = "$ROUTE",
       /*//*${YoutubePlayerArgs.PRODUCTION_CODE}*/
        arguments = listOf(navArgument(YoutubePlayerArgs.PRODUCTION_CODE) { NavType.StringType })*/
    ) {
        MoviePlayer()
    }
}

//fun NavController.navigateMoviePlayer(movieId:String,builder: NavOptionsBuilder.() -> Unit = {}) {
//    navigate(
//        route = "$ROUTE/${movieId}",
//        builder = builder
//    )
//}