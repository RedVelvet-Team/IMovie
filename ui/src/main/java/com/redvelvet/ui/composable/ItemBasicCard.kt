package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.R
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
    Column {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "movie poster image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        if (hasName) {
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                style = Typography.labelMedium,
                modifier = Modifier.padding(
                    bottom = MaterialTheme.spacing.spacing2,
                    top = MaterialTheme.spacing.spacing4
                )
            )
        }
        if (hasDateAndCountry) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = date,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.color.fontAccent,
                    style = Typography.labelSmall
                )
                Text(
                    text = country,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.color.fontAccent,
                    style = Typography.labelSmall
                )
            }
        }
    }
}