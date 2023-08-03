package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.RateStarColor
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing


@Composable
fun MediaRateRow(mediaRate: String, onRateMedia: () -> Unit) {
    Row {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.rated_star),
                contentDescription = stringResource(R.string.rated_star),
                tint = RateStarColor
            )
            SpacerHorizontal(width = MaterialTheme.spacing.spacing4)
            Row {
                BodyMediumText("$mediaRate/")
                Text(
                    text = "10",
                    style = Typography.labelMedium,
                    color = FontSecondary
                )
                BodyMediumText(" Rating")
            }
        }
        SpacerHorizontal(width = MaterialTheme.spacing.spacing16)
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .clickable { onRateMedia() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.rate_action_star),
                contentDescription = stringResource(R.string.rated_star),
                tint = RateStarColor
            )
            SpacerHorizontal(width = MaterialTheme.spacing.spacing4)
            BodyMediumText("Rate This")
        }
    }
}

