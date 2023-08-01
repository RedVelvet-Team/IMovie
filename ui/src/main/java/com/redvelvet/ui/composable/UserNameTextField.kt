package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R

@Composable
fun UserNameTextField(
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean,
    text: String,
    onClick: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onClick(it) },
        label = { Text(text) },
        singleLine = true,
        leadingIcon = {
            Icon(
                Icons.Default.Person,
                contentDescription = stringResource(R.string.person_icon)
            )
        },
        shape = RoundedCornerShape(16.dp),
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            disabledTextColor = Color.White,
            focusedContainerColor = Color(0xFF20233C),
            unfocusedContainerColor = Color(0xFF20233C),
            disabledContainerColor = Color(0xFF20233C),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            cursorColor = Color.White
        )
    )
}
