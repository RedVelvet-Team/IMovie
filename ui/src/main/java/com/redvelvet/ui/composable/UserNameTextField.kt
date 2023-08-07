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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.screen.login.LoginScreen
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius

@Composable
fun UserNameTextField(
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    value: String,
    isError: Boolean,
    text: String,
    errorMessage: String = "",
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
                contentDescription = "person icon"
            )
        },
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        isError = isError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            disabledTextColor = Color.White,
            focusedContainerColor = MaterialTheme.color.backgroundSecondary,
            unfocusedContainerColor = MaterialTheme.color.backgroundSecondary,
            disabledContainerColor = MaterialTheme.color.backgroundSecondary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            cursorColor = Color.White,
            errorBorderColor = Color.Red,
        ),
    )
}