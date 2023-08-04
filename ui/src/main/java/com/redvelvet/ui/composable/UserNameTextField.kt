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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.radius

@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean,
    text: String,
    errorMessage: String = "",
    onClick: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onClick(it) },
        label = { Text(text = text) },
        singleLine = true,
        supportingText = {
            if(isError)
                Text(
                    text = errorMessage,
                    color = Color.Red
                )
        },
        leadingIcon = {
            Icon(
                Icons.Default.Person,
                contentDescription = stringResource(R.string.person_icon)
            )
        },
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            disabledTextColor = Color.White,
            focusedContainerColor = Secondary,
            unfocusedContainerColor = Secondary,
            disabledContainerColor = Secondary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            cursorColor = Color.White,
            errorBorderColor = Color.Red,
        ),
    )
}
