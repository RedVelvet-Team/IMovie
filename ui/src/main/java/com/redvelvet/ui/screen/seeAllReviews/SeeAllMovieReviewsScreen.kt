package com.redvelvet.ui.screen.seeAllReviews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movie_details_seeall.SeeAllMovieReviewsViewModel
import com.redvelvet.viewmodel.movie_details_seeall.SeeAllReviewsUiState

@Composable
fun SeeAllReviewsScreen(
    viewModel: SeeAllMovieReviewsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    SeeAllReviewsContent(state)
}

@Composable
private fun SeeAllReviewsContent(state: SeeAllReviewsUiState) {

    MovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
        hasTopBar = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = MaterialTheme.spacing.spacing64)
        ) {

        }
    }
}