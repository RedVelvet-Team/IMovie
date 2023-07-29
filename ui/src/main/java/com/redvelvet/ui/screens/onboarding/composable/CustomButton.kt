package com.redvelvet.ui.screens.onboarding.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = Purple100,
    textColor: Color = FontSecondary
) {
    Button(
        modifier = Modifier
            .height(49.dp)
            .width(110.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(MaterialTheme.radius.radius16)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(4.dp),
            style = Typography.bodyMedium.copy(color = textColor)
        )

    }
}