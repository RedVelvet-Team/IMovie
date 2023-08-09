package com.redvelvet.ui.composable



import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.redvelvet.ui.theme.spacing

@Composable
fun LoginDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = Color.White.copy(alpha = 0.3f),
        thickness = MaterialTheme.spacing.spacing2
    )
}