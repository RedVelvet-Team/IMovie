package com.redvelvet.ui.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Typography

@Composable
fun TextStyleForDate(text : String, modifier: Modifier=Modifier){
    Text(
        modifier= modifier,
        text = text,
        style = Typography.displaySmall,
        color = FontAccent,
    )
}