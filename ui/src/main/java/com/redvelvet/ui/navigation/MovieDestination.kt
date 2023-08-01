package com.redvelvet.ui.navigation

sealed class MovieDestination(val route: String) {
    data object Testing : MovieDestination("test")
    data object Splash : MovieDestination("splash")
    data object OnBoarding : MovieDestination("onBoarding")
    data object Login : MovieDestination("login")
    data object Home : MovieDestination("home")
    data object Search : MovieDestination("search")
    data object MovieDetails : MovieDestination("movie_details")

}