package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun KeywordChip(
    text: String
) {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(color = Secondary)
            .padding(
                vertical = MaterialTheme.spacing.spacing8,
                horizontal = MaterialTheme.spacing.spacing16
            ),
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = FontSecondary,
    )
}