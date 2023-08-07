package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    buttonColor: Color = MaterialTheme.color.brand100,
    textColor: Color = MaterialTheme.color.fontSecondary,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier.height(MaterialTheme.dimens.dimens56),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        enabled = enabled
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(MaterialTheme.spacing.spacing4),
            style = Typography.headlineMedium.copy(color = textColor)
        )

    }
}