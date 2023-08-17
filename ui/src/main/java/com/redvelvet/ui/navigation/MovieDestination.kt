package com.redvelvet.ui.navigation

import com.redvelvet.ui.R

sealed class MovieDestination(
    val route: String,
    val isSelected: Int? = null,
    val isUnSelected: Int? = null
) {
    data object Splash : MovieDestination("splash")
    data object OnBoarding : MovieDestination("onBoarding")
    data object ActorDetails : MovieDestination("actorDetails")
    data object ActorKnownFor : MovieDestination("actorKnownFor")
    data object Login : MovieDestination("login")
    data object SignUp : MovieDestination("signup")
    data object SeeAllUpcoming : MovieDestination("seeAllUpcoming")
    data object SeeAllTvShow : MovieDestination("seeAllTvShow")
    data object ForgotPassword : MovieDestination("forgotPassword")

    data object Home : MovieDestination(
        "home",
        R.drawable.icon_home_filled,
        R.drawable.icon_home
    )

    data object Search : MovieDestination(
        "search",
        R.drawable.icon_search_filled,
        R.drawable.icon_search
    )

    data object Category : MovieDestination(
        "category",
        R.drawable.icon_categories_filled,
        R.drawable.icon_categories
    )

    data object Library : MovieDestination(
        "library",
        R.drawable.icon_library_filled,
        R.drawable.icon_library
    )

    data object Game : MovieDestination(
        "game",
        R.drawable.icon_game_filled,
        R.drawable.icon_game
    )

    data object MovieDetails : MovieDestination("movie_details")
    data object TvShowDetails : MovieDestination("tvshow_details")

}