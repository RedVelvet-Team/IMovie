package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
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
    buttonHeight: Dp =MaterialTheme.dimens.dimens56,
    enabled: Boolean = true,
    textColor: Color = MaterialTheme.color.fontSecondary,
    textStyle:TextStyle= MaterialTheme.typography.headlineMedium,
    buttonShape:RoundedCornerShape= RoundedCornerShape(MaterialTheme.radius.radius16)
) {
    OutlinedButton(
        onClick = onClick,
        border = border,
        shape = buttonShape,
        modifier = modifier
            .height(buttonHeight)
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
            style = textStyle,
            color = textColor,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun Preview(){
    PrimaryOutlinedButton({},"Done")
}