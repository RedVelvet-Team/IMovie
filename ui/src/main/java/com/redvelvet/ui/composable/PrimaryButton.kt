package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    hasIcon: Boolean = false,
    iconPainter: Painter = painterResource(id = R.drawable.icon_profile),
    buttonColor: Color = MaterialTheme.color.brand100,
    textColor: Color = MaterialTheme.color.fontSecondary,
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    enabled: Boolean = true,
    buttonShape: RoundedCornerShape=RoundedCornerShape(MaterialTheme.radius.radius16)
) {
    Button(
        modifier = modifier
            .height(MaterialTheme.dimens.dimens56)
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape =buttonShape,
        enabled = enabled
    ) {
        AnimatedVisibility(hasIcon) {
            Icon(
                iconPainter,
                contentDescription = "$iconPainter icon",
                modifier.padding(end = MaterialTheme.spacing.spacing4)
            )
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(MaterialTheme.spacing.spacing4),
            style = textStyle,
            color = textColor,
            maxLines = 1
        )
    }
}

@Composable
@Preview
fun PreviewPrimaryButton() {
    PrimaryButton(
        onClick = { /*TODO*/ },
        text = "add to list",
        hasIcon = true,
        iconPainter = painterResource(id = R.drawable.icon_add_to_list)
    )
}