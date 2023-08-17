package com.redvelvet.ui.screen.seeall.seasons

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.SeeAllSeasonsRoute() {
    composable(route = MovieDestination.SeeAllSeasons.route) {
        SeeAllSeasonsScreen()
    }
}

fun NavController.navigateToSeeAllSeasons() {
    navigate(MovieDestination.SeeAllSeasons.route, androidx.navigation.navOptions{
        popUpTo(MovieDestination.SeeAllSeasons.route){
            inclusive = true
        }
    })
}