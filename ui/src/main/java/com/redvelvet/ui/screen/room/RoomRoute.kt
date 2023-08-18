package com.redvelvet.ui.screen.room

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.login.LoginScreen

fun NavGraphBuilder.roomRoute() {
    composable(route = MovieDestination.Room.route) {
        LoginScreen()
    }
}

fun NavController.navigateToRoom(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Room.route, builder = builder)
}