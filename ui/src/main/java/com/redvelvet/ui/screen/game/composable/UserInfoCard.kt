package com.redvelvet.ui.screen.game.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color

@Composable
fun UserInfoCard(
    title: String,
    iconPainter: Painter,
    text: String
) {
    Column(
        modifier = Modifier
            .width(158.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Secondary)
            .padding(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = text,
                style = Typography.headlineSmall,
                color = MaterialTheme.color.fontSecondary
            )
            Icon(
                painter = iconPainter,
                contentDescription = "",
                tint = Color(0xDEF8C33C)
            )
        }

        Text(
            text = title,
            style = Typography.labelMedium,
            color = Color(0x61FFFFFF)
        )
    }
}