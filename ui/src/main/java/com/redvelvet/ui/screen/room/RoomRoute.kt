package com.redvelvet.ui.screen.room

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.roomRoute() {
    composable(route = MovieDestination.Room.route) {
        RoomScreen()
    }
}

fun NavController.navigateToRoom(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Room.route, builder = builder)
}