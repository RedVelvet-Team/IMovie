package com.redvelvet.ui.composable

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ProgressIndicator(modifier: Modifier = Modifier){
    CircularProgressIndicator(
        color = Color.White,
        modifier = modifier,
    )
}