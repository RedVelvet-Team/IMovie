package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius

@Composable
fun PrimaryTextField(
    onTextChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    placeHolderText: String,
    modifier: Modifier = Modifier,
    errorMessage: String = "",
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    onClickTrailingIcon: () -> Unit = {},
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    iconTint: Color = MaterialTheme.color.fontSecondary,
    textColor: Color = MaterialTheme.color.fontSecondary,
    placeHolderColor: Color = MaterialTheme.color.fontSecondary,
) {
    TextField(
        value = value,
        onValueChange = onTextChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = TextStyle(
            color = MaterialTheme.color.fontPrimary,
        ),
        placeholder = {
            Text(
                text = placeHolderText, style = Typography.bodyMedium,
                color = placeHolderColor,
            )
        },
        singleLine = true,
        supportingText = {
            AnimatedVisibility(isError) {
                Text(text = errorMessage, color = Color.Red)
            }
        },
        leadingIcon = {
            leadingIcon?.let { icon ->
                Icon(
                    painter = icon, contentDescription = "$leadingIcon icon", tint = iconTint
                )
            }
        },
        trailingIcon = {
            trailingIcon?.let { icon ->
                Icon(icon,
                    contentDescription = "$trailingIcon icon",
                    tint = iconTint,
                    modifier = Modifier.clickable { onClickTrailingIcon() })
            }
        },
        keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password)
        else KeyboardOptions.Default,
        visualTransformation = if (isPassword && isPasswordVisible) VisualTransformation.None
        else if (isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorContainerColor = MaterialTheme.color.backgroundSecondary,
            errorIndicatorColor = Color.Transparent,
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