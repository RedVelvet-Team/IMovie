package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun StatusText(modifier: Modifier = Modifier, statusTitle: String, statusDescription: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = statusTitle,
            style = Typography.labelLarge,
            color = FontSecondary
        )
        Text(
            text = statusDescription,
            style = Typography.displaySmall,
            color = FontAccent,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4)
        )
    }
}