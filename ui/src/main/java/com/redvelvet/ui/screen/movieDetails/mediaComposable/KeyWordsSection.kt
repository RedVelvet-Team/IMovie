package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.KeywordChip
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun KeyWordsSection(
    it: List<MovieDetailsScreenUiState.MovieKeyWordsUiState>,
    uiEvent: MovieDetailsUiEvent
) {
    Text(
        modifier = Modifier.padding(
            bottom = MaterialTheme.spacing.spacing8,
            start = MaterialTheme.spacing.spacing16
        ),
        text = "Keywords",
        style = MaterialTheme.typography.displayMedium,
        color = FontSecondary
    )
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.spacing16,
        ),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
    ) {
        items(it.size) { it2 ->
            KeywordChip(
                onClickChip = { uiEvent.onMovieKeyword(it[it2].keywordId) },
                text = it[it2].keywordString,
            )

        }
    }
}
