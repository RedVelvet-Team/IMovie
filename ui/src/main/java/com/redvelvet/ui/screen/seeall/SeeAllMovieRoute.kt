package com.redvelvet.ui.screen.seeall

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieArgs
import com.redvelvet.viewmodel.utils.SeeAllMovie

private val ROUTE = MovieDestination.SeeAllMovie.route
fun NavGraphBuilder.seeAllMovieListRoute() {
    composable(
        route = "$ROUTE/{${SeeAllMovieArgs.ID}}/{${SeeAllMovieArgs.TYPE}}",
        arguments = listOf(
            navArgument(SeeAllMovieArgs.ID) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(SeeAllMovieArgs.TYPE) { NavType.EnumType(SeeAllMovie::class.java) }
        )
    ) {
        SeeAllMovieScreen()
    }
}

fun NavController.navigateToSeeAllMovie(
    id: String?,
    type: SeeAllMovie,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = "${ROUTE}/${id}/${type}", builder = builder)
}