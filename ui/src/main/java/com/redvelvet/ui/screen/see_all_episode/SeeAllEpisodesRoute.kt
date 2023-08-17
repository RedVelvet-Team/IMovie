package com.redvelvet.ui.screen.see_all_episode

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllEpisodeRoute() {
    composable(route = MovieDestination.SeeAllEpisodes.route) {
        SeeAllEpisodeScreen()
    }
}

fun NavController.navigateToSeeAllEpisode() {
    navigate(MovieDestination.SeeAllEpisodes.route, androidx.navigation.navOptions {
        popUpTo(MovieDestination.SeeAllEpisodes.route) {
            inclusive = true
        }
    })
}