package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.screen.forgot_password.forgotPasswordRoute
import com.redvelvet.ui.screen.actor_details.actorDetailsRoute
import com.redvelvet.ui.screen.home.homeRoute
import com.redvelvet.ui.screen.known_for.actorKnownForRoute
import com.redvelvet.ui.screen.login.loginRoute
import com.redvelvet.ui.screen.movieDetails.movieDetailsRoute
import com.redvelvet.ui.screen.onboarding.onBoardingRoute
import com.redvelvet.ui.screen.search.searchRoute
import com.redvelvet.ui.screen.seeAllMovieImages.seeAllMovieImaesRoute
import com.redvelvet.ui.screen.seeAllReviews.seeAllMovieReviewsRoute
import com.redvelvet.ui.screen.episodes.seeAllEpisodeRoute
import com.redvelvet.ui.screen.seealltv.seeAllTvListRoute
import com.redvelvet.ui.screen.seeall.seeAllMovieListRoute
import com.redvelvet.ui.screen.sellAllTopCast.seeAllTopCastRoute
import com.redvelvet.ui.screen.signup.signupRoute
import com.redvelvet.ui.screen.splash.splashRoute
import com.redvelvet.ui.screen.tvshowdetails.tvShowDetailsRoute

@Composable
fun MovieNavGraph() {
    NavHost(LocalNavController.current, startDestination = MovieDestination.Splash.route) {
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
        seeAllTopCastRoute()
        seeAllMovieImaesRoute()
        seeAllMovieReviewsRoute()
        seeAllEpisodeRoute()
    }
}