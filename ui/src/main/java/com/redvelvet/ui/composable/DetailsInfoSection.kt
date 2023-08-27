package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.spacing

@Composable
fun DetailsInfoSection(
    id: Int = 0,
    image: String = "",
    name: String = "",
    genres: List<String> = emptyList(),
    hasTime: Boolean = false,
    hasDate: Boolean = false,
    seriesDate: String = "",
    spokenLanguages: String = "",
    onClickGenre: (genre: String) -> Unit = {},
    onClickRate: (id: Int, rate: Double) -> Unit,
    voteAverage: Double = 0.0,
    description: String = "",
    isRated: Boolean
) {
    Column(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.spacing16,
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        MediaInfoCard(
            posterPath = image,
            originalTitle = name,
            genres = genres,
            hasTime = hasTime,
            hasDate = hasDate,
            seriesDate = seriesDate,
            spokenLanguages = spokenLanguages,
            onClickGenre = onClickGenre,
        )
        MediaRateRow(
            isRated, voteAverage.toString()
        ) { onClickRate(id, 5.5) }
        if (description.isNotEmpty())
            Box(
                modifier = Modifier
                    .padding(end = MaterialTheme.spacing.spacing16)
            ) {
                LongExpandedText(description)
            }
    }
}
