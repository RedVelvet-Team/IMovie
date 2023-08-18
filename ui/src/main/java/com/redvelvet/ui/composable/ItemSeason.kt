package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemSeason(
    id: Int,
    seriesId: Int,
    image: Painter,
    name: String,
    date: String,
    episodesNum: Int,
    description: String,
    rate: Double,
    onClickItem: (seriesId: Int, seasonId: Int) -> Unit
) {
    Row(modifier = Modifier.padding(end = MaterialTheme.spacing.spacing8)) {
        Image(
            painter = image,
            contentDescription = "poster",
            modifier = Modifier
                .width(MaterialTheme.dimens.dimens140)
                .height(MaterialTheme.dimens.dimens118)
                .padding(MaterialTheme.spacing.spacing4)
                .clip(shape = RoundedCornerShape(MaterialTheme.radius.radius16))
                .clickable { onClickItem(seriesId, id) },
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.spacing12,
                end = MaterialTheme.spacing.spacing8,
                top = MaterialTheme.spacing.spacing12
            )
        ) {
            NameWithRatingRow(name = name, rating = rate, textNameStyle = Typography.headlineSmall)
            Text(
                text = date + " | " + episodesNum + " Episodes",
                style = Typography.displaySmall,
                color = FontAccent,
                modifier = Modifier.padding(
                    bottom = MaterialTheme.spacing.spacing12,
                    top = MaterialTheme.spacing.spacing4
                )
            )
            Text(
                text = description,
                style = Typography.displaySmall,
                color = FontSecondary,
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing8),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}