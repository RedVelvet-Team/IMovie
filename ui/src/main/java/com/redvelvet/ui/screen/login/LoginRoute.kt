package com.redvelvet.ui.screen.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.loginRoute() {
    composable(route = MovieDestination.Login.route) {
        LoginScreen()
    }
}

fun NavController.navigateToLogin(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Login.route, builder = builder)
}