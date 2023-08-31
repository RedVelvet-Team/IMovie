package com.redvelvet.ui.screen.game.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography

@Composable
fun PlayerCard(
    name: String,
    score: String,
    iconPainter: Painter,
    rankIcon: Painter? = null,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Secondary)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(42.dp),
            painter = iconPainter,
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            color = FontPrimary
        )

        AnimatedVisibility(visible = rankIcon != null) {
            Icon(
                painter = rankIcon!!,
                contentDescription = "",
                tint = Color(0xDEF8C33C)
            )
        }

        Spacer(modifier = Modifier.width(100.dp))
        Text(
            text = score,
            style = Typography.headlineSmall,
            color = Color(0xFFE9C03C)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_point),
            contentDescription = "",
            tint = Color(0xDEF8C33C)
        )
    }
}