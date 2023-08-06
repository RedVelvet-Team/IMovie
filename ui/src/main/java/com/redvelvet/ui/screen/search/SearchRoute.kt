package com.redvelvet.ui.screen.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.searchRoute() {
    composable(route = MovieDestination.Search.route) {
        SearchScreen()
    }
}

fun NavController.navigateToSearch(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Search.route, builder = builder)
}