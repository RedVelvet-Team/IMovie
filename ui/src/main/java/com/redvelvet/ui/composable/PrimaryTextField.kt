package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius

@Composable
fun PrimaryTextField(
    onClick: (String) -> Unit,
    value: String,
    isError: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    errorMessage: String = "",
    leadingIcon: Painter = painterResource(id = R.drawable.icon_user),
    trailingIcon: Painter = painterResource(id = R.drawable.icon_cancel),
    isFieldEmpty: Boolean = false,
    iconTint: Color = MaterialTheme.color.fontSecondary,
    textColor: Color = MaterialTheme.color.fontSecondary,
    placeHolderColor: Color = MaterialTheme.color.fontSecondary
) {

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        textStyle = TextStyle(
            color = MaterialTheme.color.fontPrimary,
        ),
        placeholder = {
            Text(
                text = text,
                style = Typography.bodyMedium,
                color = placeHolderColor
            )
        },
        onValueChange = { onClick(it) },
        singleLine = true,
        supportingText = {
            if (isError) {
                Text(text = errorMessage, color = Color.Red)
            }
        },
        leadingIcon = {
            Icon(
                leadingIcon,
                contentDescription = "$leadingIcon icon",
                tint = iconTint
            )
        },
        trailingIcon = {
            if (!isFieldEmpty) {
                Icon(
                    painter = trailingIcon,
                    contentDescription = "$trailingIcon icon",
                    tint = iconTint
                )
            }
        },
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor,
            focusedContainerColor = MaterialTheme.color.backgroundSecondary,
            unfocusedContainerColor = MaterialTheme.color.backgroundSecondary,
            disabledContainerColor = MaterialTheme.color.backgroundSecondary,
            cursorColor = Color.White,
        ),

        )

}