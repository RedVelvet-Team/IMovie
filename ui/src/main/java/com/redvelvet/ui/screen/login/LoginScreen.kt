package com.redvelvet.ui.screen.login

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.composable.PrimaryTextField
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.forgot_password.navigateToForgotPassword
import com.redvelvet.ui.screen.home.navigateToHome
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.ui.util.launchCollectLatest
import com.redvelvet.viewmodel.login.LoginInteraction
import com.redvelvet.viewmodel.login.LoginUiEffect
import com.redvelvet.viewmodel.login.LoginUiState
import com.redvelvet.viewmodel.login.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val navController = LocalNavController.current
    val context = LocalContext.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    val uiState by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launchCollectLatest(viewModel.effect) { effect ->
            when (effect) {
                is LoginUiEffect.NavigateTomHomeScreen -> {
                    navController.navigateToHome {
                        popUpTo(MovieDestination.Login.route) {
                            inclusive = true
                        }
                        popUpTo(MovieDestination.OnBoarding.route) {
                            inclusive = true
                        }
                    }
                }

                is LoginUiEffect.ShowToastError -> {
                    uiState.error?.let { error ->
                        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                    }
                }

                is LoginUiEffect.NavigateToForgotPassword -> {
                    navController.navigateToForgotPassword()
                }
            }
        }
    }

    LoginScreenContent(uiState, viewModel)
}

@Composable
private fun LoginScreenContent(
    uiState: LoginUiState,
    interaction: LoginInteraction,
) {
    val context = LocalContext.current
    AnimatedVisibility(uiState.isLoading) {
        Dialog(onDismissRequest = { }) {
            CircularProgressIndicator()
        }
    }
    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(context.resources, R.drawable.login)

    AnimatedVisibility(LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
        Box {
            Image(
                bitmap = imageBitmap,
                contentDescription = "Login Image",
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens365)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
            Card(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.spacing285)
                    .fillMaxWidth()
                    .shadow(MaterialTheme.spacing.spacing0),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.color.backgroundPrimary),
                shape = RoundedCornerShape(
                    topStart = MaterialTheme.radius.radius32, topEnd = MaterialTheme.radius.radius32
                )
            ) {
                LoginContentPortrait(uiState = uiState, interaction = interaction)
            }
        }
    }
    AnimatedVisibility(LocalConfiguration.current.orientation != Configuration.ORIENTATION_PORTRAIT) {
        Row {
            LoginContentLandscape(uiState = uiState, interaction = interaction)
            Image(
                bitmap = imageBitmap,
                contentDescription = "Login Image",
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens365)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
private fun LoginContentPortrait(
    uiState: LoginUiState,
    interaction: LoginInteraction,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = MaterialTheme.spacing.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 32.dp),
            style = Typography.headlineLarge.copy(
                fontSize = 24.sp, color = MaterialTheme.color.fontPrimary
            ),
            color = MaterialTheme.color.fontPrimary
        )
        Text(
            text = "Login to your account",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = MaterialTheme.spacing.spacing4),
            style = Typography.displayMedium.copy(
                fontSize = 16.sp, color = MaterialTheme.color.fontPrimary
            )
        )
        PrimaryTextField(
            value = uiState.userName,
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing24, bottom = MaterialTheme.spacing.spacing8
            ),
            isError = uiState.isUserNameEmpty,
            leadingIcon = painterResource(id = R.drawable.icon_user),
            errorMessage = "Invalid Username",
            placeHolderText = "Username",
            onTextChange = interaction::onUserNameChanged
        )
        val iconPassword = if (uiState.isPasswordVisible) R.drawable.icon_visibility_off
        else R.drawable.icon_visibility_on
        PrimaryTextField(
            value = uiState.password,
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.spacing16
            ),
            leadingIcon = painterResource(id = R.drawable.icon_password),
            trailingIcon = painterResource(iconPassword),
            onClickTrailingIcon = { interaction.onClickEyeIcon() },
            isPassword = true,
            isPasswordVisible = uiState.isPasswordVisible,
            isError = uiState.isPasswordEmpty,
            errorMessage = "Invalid password",
            placeHolderText = "Password",
            onTextChange = interaction::onPasswordChanged
        )
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = MaterialTheme.spacing.spacing16)
                .clickable { interaction.onClickForgotPassword() },
            style = Typography.titleSmall.copy(color = MaterialTheme.color.fontPrimary),
        )
        PrimaryButton(
            onClick = { interaction.onClickLogin() },
            enabled = !uiState.isLoading,
            text = "Login",
        )
        Row(
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.spacing16),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier.weight(1f),
                color = Color.White.copy(alpha = 0.3f),
                thickness = MaterialTheme.spacing.spacing2
            )
            Text(
                "OR",
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing8),
                style = Typography.displaySmall.copy(color = MaterialTheme.color.fontPrimary)
            )
            Divider(
                modifier = Modifier.weight(1f),
                color = Color.White.copy(alpha = 0.3f),
                thickness = MaterialTheme.spacing.spacing2
            )
        }
        PrimaryOutlinedButton(
            onClick = { interaction.onClickGuest() },
            enabled = !uiState.isLoading,
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1, color = MaterialTheme.color.brand100
            ),
            text = "Continue as a guest",
            textColor = MaterialTheme.color.brand100,
        )
    }
}

@Composable
private fun LoginContentLandscape(
    uiState: LoginUiState,
    interaction: LoginInteraction,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight()
            .background(MaterialTheme.color.backgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing24),
            style = Typography.headlineMedium,
            color = MaterialTheme.color.fontPrimary
        )
        Text(
            text = "Login to your account", modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing4, bottom = MaterialTheme.spacing.spacing8
            ), style = Typography.displaySmall, color = MaterialTheme.color.fontPrimary
        )
        PrimaryTextField(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing16),
            value = uiState.userName,
            isError = uiState.isUserNameEmpty,
            leadingIcon = painterResource(id = R.drawable.icon_user),
            placeHolderText = "Username",
            errorMessage = "Invalid Username",
            onTextChange = interaction::onUserNameChanged
        )
        val iconPassword = if (uiState.isPasswordVisible) R.drawable.icon_visibility_off
        else R.drawable.icon_visibility_on
        PrimaryTextField(
            value = uiState.password,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.spacing16)
                .padding(
                    top = MaterialTheme.spacing.spacing4, bottom = MaterialTheme.spacing.spacing8
                ),
            isPassword = true,
            leadingIcon = painterResource(id = R.drawable.icon_password),
            trailingIcon = painterResource(iconPassword),
            isPasswordVisible = uiState.isPasswordVisible,
            onClickTrailingIcon = { interaction.onClickEyeIcon() },
            isError = uiState.isPasswordEmpty,
            placeHolderText = "Password",
            errorMessage = "Invalid Password",
            onTextChange = interaction::onPasswordChanged
        )
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing16),
            onClick = { interaction.onClickLogin() },
            enabled = !uiState.isLoading,
            text = "Login",
        )
        PrimaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing12,
                    start = MaterialTheme.spacing.spacing12,
                    end = MaterialTheme.spacing.spacing12
                ),
            onClick = { interaction.onClickGuest() },
            enabled = !uiState.isLoading,
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1, color = MaterialTheme.color.brand100
            ),
            text = "Continue as a guest",
            textColor = MaterialTheme.color.brand100,
        )
    }
}

