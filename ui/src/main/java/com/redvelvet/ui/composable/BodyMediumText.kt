package com.redvelvet.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography

@Composable
fun BodyMediumText(text: String) {
    Text(
        text = text,
        style = Typography.bodyMedium,
        color = FontSecondary
    )
}