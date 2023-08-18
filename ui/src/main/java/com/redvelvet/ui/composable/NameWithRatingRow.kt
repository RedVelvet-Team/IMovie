package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.spacing

@Composable
fun NameWithRatingRow(
    name: String,
    rating: Double,
    textNameStyle: TextStyle,
    rowModifier: Modifier = Modifier,
) {
    Row(modifier = rowModifier) {
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            style = textNameStyle,
            color = FontPrimary,
            maxLines = 1,
            modifier = rowModifier.weight(3f)
        )

        TextWithIcon(
            text = rating.toString(),
            modifier = rowModifier.weight(2f),
            icon = painterResource(id = R.drawable.icon_star_filled)
        )
    }
}