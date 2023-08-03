package com.redvelvet.ui.screen.movieDetails

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

class MovieEventsTest : MovieDetailsUiEvent {
    override fun onMovieFavorite(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onMovieSave(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onBack() {
        TODO("Not yet implemented")
    }

    override fun onPlayTrailer() {
        TODO("Not yet implemented")
    }

    override fun onMovieCategory(category: String) {
        TODO("Not yet implemented")
    }

    override fun onTopCastSeeAll() {
        TODO("Not yet implemented")
    }

    override fun onCast(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onMovieKeyword(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onSimilarMovieSeeAll() {
        TODO("Not yet implemented")
    }

    override fun onRecommendedMovieSeeAll() {
        TODO("Not yet implemented")
    }

    override fun onMovie(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onMovieImagesSeeAll() {
        TODO("Not yet implemented")
    }

    override fun onMovieImage(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onMovieReviewsSeeAll() {
        TODO("Not yet implemented")
    }

    override fun onMovieReview(id: Int) {
        TODO("Not yet implemented")
    }

    override fun onRateMedia(rate: Double) {
        TODO("Not yet implemented")
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