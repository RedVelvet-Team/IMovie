package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.BackgroundSecondary
import com.redvelvet.ui.theme.radius

@Composable
fun PasswordTextField(
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean,
    text: String,
    errorMessage: String = "",
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onClick(it) },
        label = { Text(text = text) },
        singleLine = true,
        supportingText = {
            if (isError)
                Text(
                    text = errorMessage,
                    color = Color.Red
                )
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    if (isPasswordVisible) Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff,
                    contentDescription = if (isPasswordVisible) stringResource(R.string.hide_password)
                    else stringResource(R.string.show_password)
                )
            }
        },
        leadingIcon = {
            Icon(
                Icons.Default.Lock,
                contentDescription = stringResource(R.string.show_and_hide_password_icon)
            )
        },
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            disabledTextColor = Color.White,
            focusedContainerColor = BackgroundSecondary,
            unfocusedContainerColor = BackgroundSecondary,
            disabledContainerColor = BackgroundSecondary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            cursorColor = Color.White,
            errorBorderColor = Color.Red,
        )
    )
}