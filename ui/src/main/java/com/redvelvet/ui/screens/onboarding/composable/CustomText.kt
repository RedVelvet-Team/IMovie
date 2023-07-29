package com.redvelvet.ui.screens.onboarding.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.Typography

@Composable
fun CustomText(
    name: String,
    modifier: Modifier,
    style: TextStyle = Typography.headlineLarge,
) {
    Text(
        text = name,
        style = Typography.headlineLarge,
        modifier = modifier,
        textAlign = TextAlign.Center,
    )
}