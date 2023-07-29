package com.redvelvet.ui.navigation

sealed class MovieDestination(val route: String) {
    data object Testing : MovieDestination("test")
}