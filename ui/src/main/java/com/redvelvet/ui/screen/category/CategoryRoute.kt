package com.redvelvet.ui.screen.category

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination

//private val ROUTE = MovieDestination.Categories.route

//fun NavGraphBuilder.categoriesRoute() {
//    composable(
//        route = "${ROUTE}/{${CategoryArgs.ID}}",
//        arguments = listOf(
//            navArgument(SeeAllMovieArgs.ID) {
//                type = NavType.StringType
//            }
//        )
//    ) {
//        CategoryScreen()
//    }
//}
fun NavGraphBuilder.categoryRoute() {
    composable(route = MovieDestination.Category.route) {
        CategoryScreen()
    }
}

//fun NavController.navigateToSeeAllCategory(
//    id: String,
//    builder: NavOptionsBuilder.() -> Unit = {}
//) {
//    navigate(route = "${ROUTE}/${id}", builder = builder)
//}
