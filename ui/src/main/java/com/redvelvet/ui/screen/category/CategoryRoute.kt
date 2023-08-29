package com.redvelvet.ui.screen.category

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

fun NavGraphBuilder.categoryRoute() {
    composable(route = MovieDestination.Category.route) {
        CategoryScreen()
    }
}