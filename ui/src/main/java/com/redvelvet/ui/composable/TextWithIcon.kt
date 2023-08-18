package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing

@Composable
fun TextWithIcon(
    text:String,
    modifier: Modifier = Modifier,
    icon:Painter = painterResource(id = R.drawable.icon_star_filled),
    textNameStyle: TextStyle = Typography.labelSmall,
    color : Color = MaterialTheme.color.fontPrimary
    ) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = icon,
            contentDescription = "icon $icon"
        )
        Text(
            text = text,
            style = textNameStyle.copy(color = color),
            color = color,
            modifier = modifier.padding(start = MaterialTheme.spacing.spacing4)
        )
    }
}