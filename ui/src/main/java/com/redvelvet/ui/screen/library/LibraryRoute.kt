package com.redvelvet.ui.screen.library

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.libraryRoute() {
    composable(route = MovieDestination.Library.route) {
        LibraryScreen()
    }
}