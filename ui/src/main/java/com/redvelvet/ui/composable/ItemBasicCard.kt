package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing


@Composable
fun ItemBasicCard(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    hasName: Boolean = false,
    name: String = "",
    hasDateAndCountry: Boolean = false,
    date: String = "",
    country: String = ""
) {
    Column(modifier, horizontalAlignment = AbsoluteAlignment.Left) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "movie poster image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(132.dp),
                contentScale = ContentScale.Crop
            )
        }
        AnimatedVisibility(hasName) {
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left,
                maxLines = 1,
                style = Typography.labelMedium.copy(color = MaterialTheme.color.fontSecondary),
                modifier = Modifier.padding(
                    bottom = MaterialTheme.spacing.spacing2, top = MaterialTheme.spacing.spacing4
                )
            )
        }
        AnimatedVisibility(hasDateAndCountry) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left
            ) {
                Text(
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    text = date,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.labelSmall.copy(color = MaterialTheme.color.fontAccent)
                )
                Text(
                    text = "($country)",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = Typography.labelSmall.copy(color = MaterialTheme.color.fontAccent)
                )
            }
        }
    }
}