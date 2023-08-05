package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun StatusText(modifier:Modifier=Modifier, statusTitle:String, statusDescription:String){
    Text(
        text = statusTitle,
        style = Typography.labelLarge,
        color = FontSecondary
    )
    Spacer( modifier = modifier.height(MaterialTheme.spacing.spacing4))
    Text(
        text = statusDescription,
        style = Typography.displaySmall,
        color = FontAccent,
        textAlign = TextAlign.Center
    )
}