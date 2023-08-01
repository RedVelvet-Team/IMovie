package com.redvelvet.ui.screen.movieDetails.homeComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun MovieDetailsForegroundContent(
    onMovieCategory: () -> Unit,
    onDescriptionMore: () -> Unit,
    onTopCastSeeAll: () -> Unit,
    onCast: () -> Unit,
    onMovieKeyword: () -> Unit,
    onSimilarMovieSeeAll: () -> Unit,
    onRecommendedMovieSeeAll: () -> Unit,
    onMovie: () -> Unit,
    onMovieImagesSeeAll: () -> Unit,
    onMovieImage: () -> Unit,
    onMovieReviewsSeeAll: () -> Unit,
    onMovieReview: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = MaterialTheme.spacing.spacing285)
            .clip(
                shape = RoundedCornerShape(
                    topStart = MaterialTheme.radius.radius32,
                    topEnd = MaterialTheme.radius.radius32
                )
            )
            .fillMaxSize()
            .background(color = Primary)
            .padding(top = MaterialTheme.spacing.spacing24)
    ) {

    }
}
