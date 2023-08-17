package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.screen.actor_details.actorDetailsRoute
import com.redvelvet.ui.screen.forgot_password.forgotPasswordRoute
import com.redvelvet.ui.screen.home.homeRoute
import com.redvelvet.ui.screen.known_for.actorKnownForRoute
import com.redvelvet.ui.screen.login.loginRoute
import com.redvelvet.ui.screen.movieDetails.movieDetailsRoute
import com.redvelvet.ui.screen.onboarding.onBoardingRoute
import com.redvelvet.ui.screen.search.searchRoute
import com.redvelvet.ui.screen.seeAllUpcoming.seeAllUpcomingListRoute
import com.redvelvet.ui.screen.episodes.seeAllEpisodeRoute
import com.redvelvet.ui.screen.seealltv.seeAllTvListRoute
import com.redvelvet.ui.screen.signup.signupRoute
import com.redvelvet.ui.screen.splash.splashRoute

@Composable
fun MovieNavGraph() {
    NavHost(LocalNavController.current, startDestination = MovieDestination.SeeAllEpisodes.route) {
        splashRoute()
        onBoardingRoute()
        actorDetailsRoute()
        actorKnownForRoute()
        searchRoute()
        loginRoute()
        homeRoute()
        seeAllTvListRoute()
        seeAllUpcomingListRoute()
        signupRoute()
        forgotPasswordRoute()
        movieDetailsRoute()
        seeAllEpisodeRoute()
    }
}