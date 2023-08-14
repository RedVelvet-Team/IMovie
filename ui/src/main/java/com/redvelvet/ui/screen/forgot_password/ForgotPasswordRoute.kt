package com.redvelvet.ui.screen.forgot_password

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.forgotPasswordRoute() {
    composable(route = MovieDestination.SignUp.route) {
        ForgotPasswordScreen()
    }
}

fun NavController.navigateToForgotPassword(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.ForgotPassword.route, builder = builder)
}
