package com.redvelvet.ui

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.BottomNavBar
import com.redvelvet.ui.composable.currentDestination
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.navigation.MovieNavGraph

val LocalNavController =
    compositionLocalOf<NavHostController> { error("No NavController found!") }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            bottomBar = {
                val visibility =
                    (currentDestination()?.route ?: "") in listOf(
                        MovieDestination.Home.route,
                        MovieDestination.Search.route,
                        MovieDestination.Category.route,
                        MovieDestination.Game.route,
                        MovieDestination.Library.route
                    )
                BottomNavBar(visibility)
            }
        ) {
            MovieNavGraph(navController)
        }
    }
}




