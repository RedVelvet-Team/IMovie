package com.redvelvet.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.navigation.MovieNavGraph

@Composable
fun MovieApp() {
    val navController = rememberNavController()
    MovieNavGraph(navController)
}
