package com.redvelvet.ui.screen.seeAllReviews

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.seeAllMovieReviewsRoute() {
    composable(route = MovieDestination.SeeAllMovieReviews.route) {
      // SeeAllMovieReviewsScreen()
    }
}

fun NavController.navigateToSeeAllTopCast(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SeeAllMovieReviews.route, builder = builder)
}