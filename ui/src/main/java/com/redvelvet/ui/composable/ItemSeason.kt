package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemSeason(
    onClickItem: (String, Int) -> Unit,
    seasonNumber: Int,
    seriesId: String,
    image: Painter,
    name: String,
    date: String,
    episodesNum: Int,
    description: String,
    rate: Double,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClickItem(seriesId.toString(), seasonNumber) }
        .padding(end = MaterialTheme.spacing.spacing8)) {
        Image(
            painter = image,
            contentDescription = "poster",
            modifier = Modifier
                .width(MaterialTheme.dimens.dimens140)
                .height(MaterialTheme.dimens.dimens118)
                .padding(MaterialTheme.spacing.spacing4)
                .clip(shape = RoundedCornerShape(MaterialTheme.radius.radius16)),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.spacing12,
                end = MaterialTheme.spacing.spacing8,
                top = MaterialTheme.spacing.spacing12
            )
        ) {
            Row {
                Text(
                    text = "Season $name",
                    style = Typography.headlineSmall,
                    color = FontPrimary,
                    modifier = Modifier.width(130.dp)

                )
                Image(
                    painter = painterResource(id = R.drawable.icon_star_filled),
                    contentDescription = stringResource(R.string.icon_rating)
                )
                Text(
                    text = rate.toString(),
                    style = Typography.displaySmall,
                    color = FontPrimary,
                    modifier = Modifier.padding(start = MaterialTheme.spacing.spacing4)
                )
            }
            Text(
                text = "$date | $episodesNum Episodes",
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
                maxLines = 2,
                modifier = Modifier
                    .width(168.dp)
                    .padding(bottom = MaterialTheme.spacing.spacing8),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}