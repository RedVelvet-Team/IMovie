package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Typography


@Composable
fun ItemBasicCard(
    image: String,
    hasName: Boolean = false,
    name: String = "No Name",
    hasDateAndCountry: Boolean = false,
    date: String = "2023-08-03",
    country: String = "Germany"
) {
    Column(
        modifier = Modifier.width(104.dp)
    ) {
        Card(
            modifier = Modifier
                .width(104.dp)
                .height(130.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = stringResource(R.string.poster),
                modifier = Modifier.fillMaxSize()
            )
        }
        VerticalSpacer(space = 4)
        if (hasName) {
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                style = Typography.labelMedium
            )
        }
        VerticalSpacer(space = 2)
        if (hasDateAndCountry) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = date,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FontAccent,
                    style = Typography.labelSmall
                )
                Text(
                    text = country,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = FontAccent,
                    style = Typography.labelSmall
                )
            }
        }
    }
}