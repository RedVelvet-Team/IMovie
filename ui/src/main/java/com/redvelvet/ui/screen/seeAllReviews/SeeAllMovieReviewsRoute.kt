package com.redvelvet.ui.screen.seeAllReviews

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.movie_details_seeall.AllReviewArgs

private val ROUTE = MovieDestination.SeeAllMovieReviews.route

fun NavGraphBuilder.seeAllMovieReviewsRoute() {
    composable(
        route = "${ROUTE}/{${AllReviewArgs.ID}}",
        arguments = listOf(
            navArgument(AllReviewArgs.ID) { NavType.StringType }
        )
    ) {
        SeeAllReviewsScreen()
    }
}

fun NavController.navigateToSeeAllReviews(id: String, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(route = "${ROUTE}/${id}", builder = builder)
}