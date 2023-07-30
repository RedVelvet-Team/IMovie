package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Typography

@Composable
fun SectionHeader(label:String,modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = Typography.titleMedium,
            color = Color.White
        )
        Text(text = "see all",
            style = Typography.labelSmall,
            color = FontAccent
        )
    }
}