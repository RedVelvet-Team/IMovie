package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.screen.actor_details.actorDetailsRoute
import com.redvelvet.ui.screen.episodes.seeAllEpisodeRoute
import com.redvelvet.ui.screen.forgot_password.forgotPasswordRoute
import com.redvelvet.ui.screen.home.homeRoute
import com.redvelvet.ui.screen.known_for.actorKnownForRoute
import com.redvelvet.ui.screen.library.libraryRoute
import com.redvelvet.ui.screen.login.loginRoute
import com.redvelvet.ui.screen.movieDetails.movieDetailsRoute
import com.redvelvet.ui.screen.movie_player.moviePlayerRoute
import com.redvelvet.ui.screen.onboarding.onBoardingRoute
import com.redvelvet.ui.screen.room.roomRoute
import com.redvelvet.ui.screen.search.searchRoute
import com.redvelvet.ui.screen.seeAllMovieImages.seeAllMovieImaesRoute
import com.redvelvet.ui.screen.seeAllReviews.seeAllMovieReviewsRoute
import com.redvelvet.ui.screen.seeall.seeAllMovieListRoute
import com.redvelvet.ui.screen.seealltv.seeAllTvListRoute
import com.redvelvet.ui.screen.seeallseasons.seeAllSeasonsRoute
import com.redvelvet.ui.screen.sellAllTopCast.seeAllTopCastRoute
import com.redvelvet.ui.screen.signup.signupRoute
import com.redvelvet.ui.screen.splash.splashRoute
import com.redvelvet.ui.screen.tvshowdetails.tvShowDetailsRoute
import com.redvelvet.ui.screen.upcoming.categoryRoute
import com.redvelvet.ui.screen.upcoming.gameRoute
import com.redvelvet.ui.screen.upcoming.upcomingRoute
import com.redvelvet.ui.screen.youtube_player.youtubePlayerRoute

@Composable
fun MovieNavGraph() {
    NavHost(LocalNavController.current, startDestination = MovieDestination.Room.route) {
        splashRoute()
        onBoardingRoute()
        actorDetailsRoute()
        actorKnownForRoute()
        searchRoute()
        loginRoute()
        homeRoute()
        seeAllTvListRoute()
        seeAllMovieListRoute()
        signupRoute()
        forgotPasswordRoute()
        movieDetailsRoute()
        tvShowDetailsRoute()
        seeAllSeasonsRoute()
        seeAllTopCastRoute()
        seeAllMovieImaesRoute()
        seeAllMovieReviewsRoute()
        seeAllEpisodeRoute()
        upcomingRoute()
        categoryRoute()
        libraryRoute()
        gameRoute()
        roomRoute()
        moviePlayerRoute()
        youtubePlayerRoute()
    }
}