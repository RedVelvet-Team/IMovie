package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.screen.home.homeRoute
import com.redvelvet.ui.screen.login.loginRoute
import com.redvelvet.ui.screen.onboarding.onBoardingRoute
import com.redvelvet.ui.screen.search.searchRoute
import com.redvelvet.ui.screen.seeAllUpcoming.seeAllUpcomingListRoute
import com.redvelvet.ui.screen.splash.splashRoute

@Composable
fun MovieNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieDestination.Login.route) {
        splashRoute(navController)
        onBoardingRoute(navController)
        searchRoute(navController)
        loginRoute(navController)
        homeRoute(navController)
        seeAllUpcomingListRoute(navController)
    }
}