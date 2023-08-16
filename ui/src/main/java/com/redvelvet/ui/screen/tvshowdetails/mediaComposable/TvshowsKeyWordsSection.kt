package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

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
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvshowsKeyWordsSection(
    it: List<String>,
    interaction: TvShowDetailsInteraction,
) {
    if (it.isNotEmpty())
        Text(
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.spacing8,
                start = MaterialTheme.spacing.spacing16
            ),
            text = "Keywords",
            style = MaterialTheme.typography.displayMedium,
            color = FontSecondary
        )
    if (it.isNotEmpty())
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                ),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        ) {
            items(it.size) { it2 ->
                KeywordChip(
                    // TODO: ADD onClickKeyword TO INTERACTIONS WITH CHANGING KEYWORDS UI STATE
                    onClickChip = {
//                    interaction.onClickKeyword(it[it2].keywordId)
                    },
                    text = it[it2],
                )

            }
        }
}
