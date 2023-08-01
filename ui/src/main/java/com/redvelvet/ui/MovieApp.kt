package com.redvelvet.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.BottomNavBar
import com.redvelvet.ui.composable.currentDestination
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.navigation.MovieNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val visibility = (currentDestination(navController)?.route ?: "") in listOf(
                MovieDestination.Home.route,
                MovieDestination.Search.route,
                MovieDestination.Category.route,
                MovieDestination.Game.route,
                MovieDestination.Library.route
            )
            BottomNavBar(navController, visibility)
        }
    ) {
        MovieNavGraph(navController)
    }
}




