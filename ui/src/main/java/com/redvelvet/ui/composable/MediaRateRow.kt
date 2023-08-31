package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.RateStarColor
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing


@Composable
fun MediaRateRow(
    isRated: Boolean,mediaType:String, mediaRate: String, onRateMedia: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(
                bottom = MaterialTheme.spacing.spacing24,
                end = MaterialTheme.spacing.spacing16
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(end = MaterialTheme.spacing.spacing16)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.rated_star),
                contentDescription = stringResource(R.string.rated_star),
                tint = RateStarColor,
                modifier = Modifier.padding(end = MaterialTheme.spacing.spacing4)
            )
            Row {
                BodyMediumText("$mediaRate/")
                Text(
                    text = "10",
                    style = Typography.labelSmall,
                    color = FontSecondary
                )
                BodyMediumText(" Rating")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Rate This $mediaType",
            style = Typography.bodyMedium,
            color = Purple100,
            modifier = Modifier.clickable { onRateMedia() }
        )
    }
}

