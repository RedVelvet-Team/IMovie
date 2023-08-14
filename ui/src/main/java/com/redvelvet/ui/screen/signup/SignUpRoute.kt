package com.redvelvet.ui.screen.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.signupRoute() {
    composable(route = MovieDestination.SignUp.route) {
        SignUpScreen()
    }
}

fun NavController.navigateToSignUp(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.SignUp.route, builder = builder)
}