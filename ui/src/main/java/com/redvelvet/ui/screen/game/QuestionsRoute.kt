package com.redvelvet.ui.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.viewmodel.game.GameArgs
import com.redvelvet.viewmodel.utils.MediaType

private val ROUTE = MovieDestination.Questions.route

fun NavGraphBuilder.questionsScreenRoute() {
    composable(
        route = "${ROUTE}/{${GameArgs.MEDIA}}",
        arguments = listOf(
            navArgument(GameArgs.MEDIA) { NavType.EnumType(MediaType::class.java) }
        )
    ) {
        QuestionsScreen()
    }
}

fun NavController.navigateToQuestionsScreen(
    type: MediaType,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(route = "${ROUTE}/${type}", builder = builder)
}