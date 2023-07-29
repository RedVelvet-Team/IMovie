package com.redvelvet.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.Typography

@Composable
fun CustomText(
    name: String,
    modifier: Modifier=Modifier,
    style: TextStyle = Typography.headlineLarge,
) {
    Text(
        text = name,
        style = style,
        modifier = modifier,
        textAlign = TextAlign.Center,
    )
}