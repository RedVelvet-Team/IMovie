package com.redvelvet.ui.screen.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.loginRoute() {
    composable(route = MovieDestination.Login.route) {
        LoginScreen()
    }
}

fun NavController.navigateToLogin() {
    navigate(MovieDestination.Login.route, androidx.navigation.navOptions {
        popUpTo(MovieDestination.Splash.route) {
            inclusive = true
        }
    })
}
