package com.redvelvet.ui.screen.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.searchRoute() {
    composable(route = MovieDestination.Search.route) {
        SearchScreen()
    }
}


