package com.redvelvet.ui.screen.movieDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.LabeledValueVertical
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.details_ui_states.MediaDetailsScreenUiState


@Composable
fun MovieDetailsMoreInfoSection(
    productionCountries: List<String>,
    status: String,
    releaseDate: String

) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.spacing16,
            end = MaterialTheme.spacing.spacing16,
            bottom = MaterialTheme.spacing.spacing24,
        )
    ) {
        LabeledValueVertical("Status", status)
        SpacerVertical(height = MaterialTheme.spacing.spacing8)
        LabeledValueVertical("Release Date", releaseDate)
        SpacerVertical(height = MaterialTheme.spacing.spacing8)
        LabeledValueVertical(
            "Production Countries",
            productionCountries.joinToString(",") { it }
        )
    }

}

