package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun EpisodeItem(
    name: String,
    rate: Double,
    date: String,
    durationTime: Int,
    image: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(Color.Transparent)
            .fillMaxWidth()
    ) {
        rememberAsyncFlixImage(
            image = image,
            modifier = modifier
                .width(MaterialTheme.dimens.dimens140)
                .height(MaterialTheme.dimens.dimens88)
                .clip(shape = RoundedCornerShape(MaterialTheme.radius.radius16)),
        )
        Column(
            modifier
                .fillMaxHeight()
                .padding(start = MaterialTheme.spacing.spacing12)) {
            NameWithRatingRow(name = name, rating = rate, textNameStyle = Typography.headlineSmall)
            TextStyleForDate(
                text = date,
                modifier = modifier
                    .padding(
                        top = MaterialTheme.spacing.spacing8,
                        bottom = MaterialTheme.spacing.spacing4
                    )
            )
            TextWithIcon(
                text = "$durationTime Min",
                icon = painterResource(id = R.drawable.time_quarter_past),
                color = MaterialTheme.color.fontAccent,
            )
        }
    }
}

