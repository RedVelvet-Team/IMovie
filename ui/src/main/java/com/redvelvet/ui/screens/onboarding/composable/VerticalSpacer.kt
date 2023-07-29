package com.redvelvet.ui.screens.onboarding.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpacer(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
}