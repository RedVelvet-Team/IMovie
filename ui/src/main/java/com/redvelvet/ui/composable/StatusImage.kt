package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun StatusImage(modifier: Modifier=Modifier,painter: Painter,contentDescription:String){
    Image(
        modifier = modifier.fillMaxWidth(),
        painter = painter,
        contentDescription = contentDescription
    )
}