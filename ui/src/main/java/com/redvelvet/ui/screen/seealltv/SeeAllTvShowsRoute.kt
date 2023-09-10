package com.redvelvet.ui.screen.seealltv

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.seeall.tv.SeeAllTvArgs
import com.redvelvet.viewmodel.utils.SeeAllTvShows

private val ROUTE = MovieDestination.SeeAllTvShow.route

fun NavGraphBuilder.seeAllTvListRoute() {
    composable(
        route = "${ROUTE}/{${SeeAllTvArgs.ID}}/{${SeeAllTvArgs.TYPE}}",
        arguments = listOf(
            navArgument(SeeAllTvArgs.ID) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(SeeAllTvArgs.TYPE) { NavType.EnumType(SeeAllTvShows::class.java) }
        )
    ) {
        SeeAllTvScreen()
    }
}

fun NavController.navigateSeeAllTvShow(id: String?, type: SeeAllTvShows, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}/${type}", builder = builder)
}