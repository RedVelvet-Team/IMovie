package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun DisplayCard(
    iconPainter: Painter,
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(MaterialTheme.color.backgroundCard)
            .padding(MaterialTheme.spacing.spacing16)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(MaterialTheme.spacing.spacing20),
                painter = iconPainter,
                contentDescription = "",
                tint = MaterialTheme.color.fontSecondary
            )
            Text(
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing8),
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.color.fontSecondary,
                textAlign = TextAlign.Center
            )

        }

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
            text = text,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )
        content()
    }
}