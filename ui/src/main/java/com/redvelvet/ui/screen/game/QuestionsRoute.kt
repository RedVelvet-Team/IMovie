package com.redvelvet.ui.screen.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.redvelvet.ui.navigation.MovieDestination


fun NavGraphBuilder.questionsScreenRoute() {
    composable(route = MovieDestination.Questions.route) {
        QuestionsScreen()
    }
}

fun NavController.navigateToQuestionsScreen(builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(MovieDestination.Questions.route, builder)
}