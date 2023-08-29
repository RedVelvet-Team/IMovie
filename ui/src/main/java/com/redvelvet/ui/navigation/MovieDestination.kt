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
    data object SeeAllMovie : MovieDestination("seeAllMovie")
    data object SeeAllUpcoming : MovieDestination("seeAllUpcoming")
    data object SeeAllSeasons : MovieDestination("seeAllSeasons")
    data object Room : MovieDestination("room")
    data object SeeAllTvShow : MovieDestination("seeAllTvShow")
    data object ForgotPassword : MovieDestination("forgotPassword")
    data object SeeAllEpisodes : MovieDestination("seeAllEpisodes")
    data object SeeAllTopCast : MovieDestination("seeAllTopCast")
    data object SeeAllMovieImages : MovieDestination("seeAllMovieImages")
    data object SeeAllMovieReviews : MovieDestination("seeAllMovieReviews")
    data object MovieDetails : MovieDestination("movieDetails")
    data object TvShowDetails : MovieDestination("tvShowDetails")
    data object Upcoming : MovieDestination("upcoming")
    data object MoviePlayer:MovieDestination("moviePlayer")
    data object YoutubePlayer : MovieDestination("youtubePlayer")


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

    data object FunActivities : MovieDestination(
        "funActivities",
        R.drawable.icon_game_filled,
        R.drawable.icon_game
    )
}