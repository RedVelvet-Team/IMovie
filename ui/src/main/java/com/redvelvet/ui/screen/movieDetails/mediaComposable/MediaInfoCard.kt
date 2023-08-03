package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.GenreButton
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.LabeledValueHorizontal
import com.redvelvet.ui.composable.SpacerHorizontal
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MediaInfoCard(movieDetails: MovieDetailsScreenUiState.MovieDetailsUiState) {
    Row {
        ItemBasicCard(
            image = movieDetails.posterPath,
            hasName = false,
            name = movieDetails.originalTitle,
            hasDateAndCountry = false,
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing12)
        Column {
            Text(
                text = movieDetails.originalTitle,
                style = Typography.headlineMedium,
                color = Color.White
            )
            SpacerVertical(height = MaterialTheme.spacing.spacing16)
            LazyRow {
                items(movieDetails.genres.size) {
                    GenreButton(genre = movieDetails.genres[it])
                }
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing12)
            LabeledValueHorizontal(
                movieTime = movieDetails.runtime,
                icon = R.drawable.movie_time,
                iconDescription = R.string.movie_time
            )
            SpacerVertical(height = MaterialTheme.spacing.spacing8)
            LabeledValueHorizontal(
                movieTime = movieDetails.spokenLanguages,
                icon = R.drawable.global,
                iconDescription = R.string.movie_language
            )
        }

    }
}