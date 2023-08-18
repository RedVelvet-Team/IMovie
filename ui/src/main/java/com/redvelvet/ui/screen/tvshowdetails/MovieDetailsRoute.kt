package com.redvelvet.ui.screen.tvshowdetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.seeall.tv.SeeAllTvArgs
import com.redvelvet.viewmodel.tvshow.TvDetailsArgs

private val ROUTE = MovieDestination.TvShowDetails.route
fun NavGraphBuilder.tvShowDetailsRoute() {
    composable(
        route = "${ROUTE}/{${TvDetailsArgs.ID}}",
        arguments = listOf(
            navArgument(SeeAllTvArgs.ID) {
                type = NavType.StringType
            }
        )
    ) {
        TvShowDetailsScreen()
    }
}

fun NavController.navigateToTvShowDetails(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}", builder = builder)
}
