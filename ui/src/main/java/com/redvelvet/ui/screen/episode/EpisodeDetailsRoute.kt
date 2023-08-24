package com.redvelvet.ui.screen.episode

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.episode.EpisodeDetailsArgs


fun NavGraphBuilder.episodeDetailsRoute() {
    composable(
        route = "${MovieDestination.EpisodeDetails.route}/{${EpisodeDetailsArgs.TV_ID}}/{${EpisodeDetailsArgs.SEASON_ID}}/{${EpisodeDetailsArgs.EPISODE_ID}}",
        arguments = listOf(
            navArgument(EpisodeDetailsArgs.TV_ID) {
                type = NavType.IntType
            },
            navArgument(EpisodeDetailsArgs.SEASON_ID) {
                type = NavType.IntType
            },
            navArgument(EpisodeDetailsArgs.EPISODE_ID) {
                type = NavType.IntType
            }
        )
    ) {
        EpisodeDetailsScreen()
    }

}

fun NavController.navigateToEpisodeDetails(
    tvId: String, seasonNumber: Int, episodeNumber: Int
) {
    navigate("${MovieDestination.EpisodeDetails.route}/${tvId}/${seasonNumber}/${episodeNumber}")
}
