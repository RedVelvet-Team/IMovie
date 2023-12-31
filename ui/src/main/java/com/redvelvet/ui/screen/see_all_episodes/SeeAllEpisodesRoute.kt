package com.redvelvet.ui.screen.see_all_episodes

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.see_all_episode.EpisodesArgs

private val ROUTE = MovieDestination.SeeAllEpisodes.route
fun NavGraphBuilder.seeAllEpisodeRoute() {
    composable(
        route = "$ROUTE/{${EpisodesArgs.TV_ID}}/{${EpisodesArgs.SEASON_Number}}",
        arguments = listOf(
            navArgument(EpisodesArgs.TV_ID) { NavType.StringType },
            navArgument(EpisodesArgs.SEASON_Number) { NavType.StringType }
        )
    ) {
        SeeAllEpisodeScreen()
    }
}

fun NavController.navigateToSeeAllEpisode(tvId: String,seasonNumber:String,builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(
        route = "$ROUTE/${tvId}/${seasonNumber}",
        builder = builder
    )
}