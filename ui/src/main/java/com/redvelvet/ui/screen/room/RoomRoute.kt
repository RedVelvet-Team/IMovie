package com.redvelvet.ui.screen.room

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.cinemaRoomRoute() {
    composable(route = MovieDestination.Room.route) { RoomScreen() }
}

fun NavController.navigateToCinemaRoom(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Room.route, builder = builder)
}