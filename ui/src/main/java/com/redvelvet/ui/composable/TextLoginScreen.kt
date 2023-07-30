package com.redvelvet.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.Montserrat

@Composable
fun TextLoginScreen(modifier: Modifier = Modifier, text: String,fontWeight: FontWeight,size: TextUnit){
    Text(
        text = text,
        modifier = modifier,
        fontFamily = Montserrat,
        fontWeight = fontWeight,
        fontSize = size,
        color = FontPrimary
    )
}
