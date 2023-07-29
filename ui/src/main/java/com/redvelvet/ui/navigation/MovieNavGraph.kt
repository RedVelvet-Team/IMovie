package com.redvelvet.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.redvelvet.ui.screen.test.testingRoute

@Composable
fun MovieNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieDestination.Testing.route){
        testingRoute(navController)
    }
}