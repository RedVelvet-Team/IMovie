package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.spacing

@Composable
fun TopCast(
    castId:Int = 0,
    castName: String = "",
    onClick: (id: Int) -> Unit = {},
    image: Painter,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick(castId) }
    ) {
        CircularImageAvatar(image = image)
        SpacerVertical(height = MaterialTheme.spacing.spacing4)
        Box(
            modifier = Modifier
                .width(70.dp)
        ) {
            Text(
                text = castName,
                style = MaterialTheme.typography.bodySmall,
                color = FontSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}
