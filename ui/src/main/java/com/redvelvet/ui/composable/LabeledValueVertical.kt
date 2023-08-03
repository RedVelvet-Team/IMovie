package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.theme.OnPrimary
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.spacing

@Composable
fun LabeledValueVertical(label: String, value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = OnSecondary,
        )
        SpacerVertical(height = MaterialTheme.spacing.spacing4)
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            color = OnPrimary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}