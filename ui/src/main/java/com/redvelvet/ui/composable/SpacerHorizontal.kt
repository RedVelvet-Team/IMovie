package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpacerHorizontal(width: Dp){
    Spacer(modifier = Modifier.width(width))
}