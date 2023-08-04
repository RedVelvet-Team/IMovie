package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.LabeledValueVertical
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState


@Composable
fun MovieDetailsMoreInfoSection(
    it: MovieDetailsScreenUiState.MovieDetailsUiState,
    uiEvent: MovieDetailsUiEvent
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        LabeledValueVertical("Status", it.status)
        SpacerVertical(height = MaterialTheme.spacing.spacing8)
        LabeledValueVertical("Release Date", it.releaseDate)
        SpacerVertical(height = MaterialTheme.spacing.spacing8)
        LabeledValueVertical(
            "Production Countries",
            it.productionCountries.joinToString(",") { it }
        )
    }

}

