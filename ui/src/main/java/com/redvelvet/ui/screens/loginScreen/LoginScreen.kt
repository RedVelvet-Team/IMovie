package com.redvelvet.ui.screens.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.Montserrat
import com.redvelvet.ui.theme.Purple100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    val uiState by viewModel.state.collectAsState()
    val context = LocalContext.current
    val imageBitmap: ImageBitmap =
        ImageBitmap.imageResource(context.resources, R.drawable.login_screen)

    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(SheetValue.Expanded)
    )

    BottomSheetScaffold(
        sheetContent = { LoginContent(uiState, viewModel) },
        scaffoldState = sheetState,
        sheetContainerColor = Color(0xFF11142D),
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetShadowElevation = 0.dp,
        sheetPeekHeight = 32.dp
    ) {
        Image(
            bitmap = imageBitmap,
            contentDescription = "Login Image",
            modifier = Modifier
                .height(365.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(uiState: LoginUiState, viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.padding(top = 0.dp, start = 24.dp, end = 24.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start),
            color = FontPrimary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Login to your account",
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.Start),
            color = FontPrimary
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = uiState.userName,
            onValueChange = { viewModel.onUserNameChanged(it) },
            label = { Text("Username") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            isError = uiState.userNameHelperText.isNotEmpty(),
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

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            isError = uiState.passwordHelperText.isNotEmpty(),
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
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { viewModel.onLoginClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !uiState.isLoading,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple100)
        ) { Text("SIGN IN", Modifier.padding(vertical = 8.dp)) }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            Text("OR", color = Color.White, modifier = Modifier.padding(horizontal = 8.dp))
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(
            onClick = { viewModel.onGuestClicked() }, modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Purple100, shape = MaterialTheme.shapes.medium)
        ) {
            Text(
                "Continue as a guest",
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = FontPrimary
            )
        }
        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}