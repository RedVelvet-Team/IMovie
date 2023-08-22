package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing


@Composable
fun ItemBasicCardForDetailsScreens(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    hasName: Boolean = false,
    name: String = "",
    id:Int,
    hasDateAndCountry: Boolean = false,
    date: String = "",
    country: String = "",
    onClick: (String) -> Unit = {},
    isMediaInfoCard: Boolean = false
) {
    Column(
        modifier = if (isMediaInfoCard) Modifier else Modifier
            .clickable { onClick(id.toString()) },
        horizontalAlignment = AbsoluteAlignment.Left
    ) {
        Image(
            painter = imagePainter,
            contentDescription = stringResource(R.string.poster),
            modifier = modifier.clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        AnimatedVisibility(hasName) {
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                style = Typography.labelMedium,
                modifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .padding(
                        bottom = MaterialTheme.spacing.spacing2,
                        top = MaterialTheme.spacing.spacing4
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
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.color.fontAccent,
                    style = Typography.labelSmall
                )
                Text(
                    text = "($country)",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.color.fontAccent,
                    style = Typography.labelSmall
                )
            }
        }
    }
}
