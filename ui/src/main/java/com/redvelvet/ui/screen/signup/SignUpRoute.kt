package com.redvelvet.ui.screen.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.signupRoute(navController: NavController) {
    composable(route = MovieDestination.SignUp.route) {
        SignUpScreen(navController = navController)
    }
}

fun NavController.navigateToSignUp(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SignUp.route, builder = builder)
}