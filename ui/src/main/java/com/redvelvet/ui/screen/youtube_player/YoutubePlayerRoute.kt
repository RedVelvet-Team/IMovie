package com.redvelvet.ui.screen.youtube_player

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.youtube_player.YoutubePlayerArgs

private val ROUTE = MovieDestination.YoutubePlayer.route

fun NavGraphBuilder.youtubePlayerRoute() {
    composable(
        route = "$ROUTE/${YoutubePlayerArgs.PRODUCTION_CODE}",
        arguments = listOf(navArgument(YoutubePlayerArgs.PRODUCTION_CODE) { NavType.StringType })
    ) {
        YoutubePlayerScreen()
    }
}

fun NavController.navigateToYoutubePlayer(productionCode:String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(
        route = "$ROUTE/${productionCode}",
        builder = builder
    )
}