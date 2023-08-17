package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.spacing

@Composable
fun KeyWordsSection(
    it: List<String>
) {
    if (it.isNotEmpty())
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                ),
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
                    KeywordChip(text = it[it2])
                }
            }
        }
}
