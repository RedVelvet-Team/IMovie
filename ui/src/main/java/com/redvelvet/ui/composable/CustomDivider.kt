package com.redvelvet.ui.composable



import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = Color.White.copy(alpha = 0.3f),
        thickness = 1.dp
    )
}