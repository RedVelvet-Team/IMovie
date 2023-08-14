package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
            style = textNameStyle,
            color = FontPrimary,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.icon_star_filled),
            contentDescription = "icon rating"
        )
        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.displaySmall,
            color = FontPrimary,
            modifier = Modifier.padding(start = MaterialTheme.spacing.spacing4)
        )
    }
}