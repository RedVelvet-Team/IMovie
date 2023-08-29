package com.redvelvet.ui.screen.categorySeeAll

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.category.SeeALlMediaArgs

private val ROUTE = MovieDestination.SeeAllCategories.route

fun NavGraphBuilder.seeAllCategoryRoute() {
    composable(
        route = "$ROUTE/{${SeeALlMediaArgs.ID}}/{${SeeALlMediaArgs.TITLE}}/{${SeeALlMediaArgs.MEDIA}}",
        arguments = listOf(
            navArgument(SeeALlMediaArgs.ID) {
                type = NavType.StringType
                nullable = false
            },
            navArgument(SeeALlMediaArgs.MEDIA) {
                type = NavType.StringType
                nullable = false
            },
            navArgument(SeeALlMediaArgs.TITLE) {
                type = NavType.StringType
                nullable = false

            }
        )
    ) {
        SeeAllCategoryScreen()
    }
}

fun NavController.navigateToSeeAllCategoryRoute(
    id: String,
    title: String,
    type: String,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = "${ROUTE}/${id}/${title}/${type}", builder = builder)
}