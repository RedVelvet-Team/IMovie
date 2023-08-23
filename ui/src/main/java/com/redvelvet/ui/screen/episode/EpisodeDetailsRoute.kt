package com.redvelvet.ui.screen.episode

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination


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


class EpisodeDetailsArgs(savedStateHandle: SavedStateHandle) {
    val tvId: Int = savedStateHandle[TV_ID] ?: 1
    val seasonId: Int = savedStateHandle[SEASON_ID] ?: 1
    val episodeId: Int = savedStateHandle[EPISODE_ID] ?: 1

    companion object {
        const val TV_ID = "id"
        const val SEASON_ID = "season"
        const val EPISODE_ID = "episode"
    }
}