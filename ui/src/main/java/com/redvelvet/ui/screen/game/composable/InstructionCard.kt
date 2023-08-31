package com.redvelvet.ui.screen.game.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color

@Composable
fun InstructionCard(
    iconPainter: Painter,
    instruction: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0x146C5DD3))
                .padding(8.dp),
            painter = iconPainter,
            contentDescription = "",
            tint = MaterialTheme.color.fontSecondary
        )
        Text(
            text = instruction,
            style = Typography.bodyMedium,
            color = MaterialTheme.color.fontSecondary
        )
    }
}