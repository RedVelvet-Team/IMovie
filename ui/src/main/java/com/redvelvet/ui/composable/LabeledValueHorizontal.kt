package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun LabeledValueHorizontal(movieTime: String, icon: Int, iconDescription: Int) {
    Row {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(iconDescription),
            tint = FontSecondary,
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing4)
        Text(
            text = movieTime,
            style = Typography.labelSmall,
            color = FontSecondary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

