package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun PrimaryOutlinedButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    hasIcon: Boolean = false,
    iconPainter: Painter = painterResource(id = R.drawable.icon_profile),
    border: BorderStroke = BorderStroke(
        width = MaterialTheme.dimens.dimens1,
        color = MaterialTheme.color.brand100
    ),
    enabled: Boolean = true,
    textColor: Color = MaterialTheme.color.fontSecondary,
) {
    OutlinedButton(
        onClick = onClick,
        border = border,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .height(MaterialTheme.dimens.dimens56)
            .fillMaxWidth(),
        enabled = enabled
    ) {
        AnimatedVisibility(hasIcon) {
            Icon(
                iconPainter,
                contentDescription = null,
                modifier.padding(end = MaterialTheme.spacing.spacing4)
            )
        }
        Text(
            text = text,
            modifier = Modifier.padding(end = MaterialTheme.spacing.spacing8),
            style = Typography.headlineMedium,
            color = textColor
        )
    }
}