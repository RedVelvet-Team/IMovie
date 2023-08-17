package com.redvelvet.ui.screen.episodes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.episode.EpisodesArgs

private val ROUTE = MovieDestination.SeeAllEpisodes.route
fun NavGraphBuilder.seeAllEpisodeRoute() {
    composable(
        route = "$ROUTE/${EpisodesArgs.TV_ID}/${EpisodesArgs.SEASON_Number}",
        arguments = listOf(
            navArgument(EpisodesArgs.TV_ID) { NavType.StringType },
            navArgument(EpisodesArgs.SEASON_Number) { NavType.IntType }
        )
    ) {
        SeeAllEpisodeScreen()
    }
}

fun NavController.navigateToSeeAllEpisode(tvId: String,seasonNumber:Int ,builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(
        route = "$ROUTE/${tvId}/${seasonNumber}",
        builder = builder
    )
}