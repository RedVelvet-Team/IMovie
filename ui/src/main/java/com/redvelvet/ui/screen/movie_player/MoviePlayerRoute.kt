package com.redvelvet.ui.screen.movie_player

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

private val ROUTE = MovieDestination.MoviePlayer.route

fun NavGraphBuilder.moviePlayerRoute() {
    composable(
        route = "$ROUTE",
       /*//*${YoutubePlayerArgs.PRODUCTION_CODE}*/
        arguments = listOf(navArgument(YoutubePlayerArgs.PRODUCTION_CODE) { NavType.StringType })*/
    ) {
        MoviePlayerScreen()
    }
}

//fun NavController.navigateMoviePlayer(movieId:String,builder: NavOptionsBuilder.() -> Unit = {}) {
//    navigate(
//        route = "$ROUTE/${movieId}",
//        builder = builder
//    )
//}