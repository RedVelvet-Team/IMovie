package com.redvelvet.ui.screen.movieDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

class MovieEventsTest : MovieDetailsUiEvent {
    override fun onMovieFavorite(id: Int) {
    }

    override fun onMovieSave(id: Int) {
    }

    override fun onBack() {
    }

    override fun onPlayTrailer() {
    }

    override fun onMovieCategory(category: String) {
    }

    override fun onTopCastSeeAll() {
    }

    override fun onCast(id: Int) {
    }

    override fun onMovieKeyword(id: Int) {
    }

    override fun onSimilarMovieSeeAll() {
    }

    override fun onRecommendedMovieSeeAll() {
    }

    override fun onMovie(id: Int) {
    }

    override fun onMovieImagesSeeAll() {
    }

    override fun onMovieImage(id: Int) {
    }

    override fun onMovieReviewsSeeAll() {
    }

    override fun onMovieReview(id: Int) {
    }

    override fun onRateMedia(rate: Double) {
    }

}

fun NavGraphBuilder.movieDetailsRoute(navController: NavController) {
    composable(route = MovieDestination.MovieDetails.route) {
        val uiEvent: MovieDetailsUiEvent = MovieEventsTest()
        MovieDetailsScreen(navController = navController, uiEvent)
    }
}

fun NavController.navigateToMovieDetails(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.MovieDetails.route, builder = builder)
}