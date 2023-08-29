package com.redvelvet.ui.screen.seeAllReviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.ItemReview
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movie_details_seeall.SeeAllMovieReviewsViewModel
import com.redvelvet.viewmodel.movie_details_seeall.SeeAllReviewsUiState

@Composable
fun SeeAllReviewsScreen(
    viewModel: SeeAllMovieReviewsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current

    FlixMovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
        hasTopBar = true
    ) {
        SeeAllReviewsContent(state)
    }

}

@Composable
private fun SeeAllReviewsContent(reviewState: SeeAllReviewsUiState) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing24
            ),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing16,
                Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.Start,
        ) {
            items(reviewState.reviews.size) { index ->
                val reviews = reviewState.reviews[index]
                ItemReview(
                    id = reviews.reviewId,
                    name = reviews.reviewAuthor,
                    rating = reviews.reviewStars,
                    date = reviews.reviewDate,
                    content = reviews.reviewDescription
                )
            }
        }
    }
}