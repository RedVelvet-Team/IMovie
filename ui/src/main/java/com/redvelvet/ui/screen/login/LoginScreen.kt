package com.redvelvet.ui.screen.login

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.composable.PrimaryTextField
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.home.navigateToHome
import com.redvelvet.ui.screen.signup.navigateToSignUp
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.login.LoginInteraction
import com.redvelvet.viewmodel.login.LoginUiEvent
import com.redvelvet.viewmodel.login.LoginUiState
import com.redvelvet.viewmodel.login.LoginViewModel
import com.redvelvet.viewmodel.utils.launchCollectLatest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    val uiState by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()
    scope.launchCollectLatest(viewModel.event) { event ->
        when (event) {
            is LoginUiEvent.NavigateTomHomeScreen -> {
                navController.navigateToHome {
                    popUpTo(MovieDestination.Login.route) {
                        inclusive = true
                    }
                }
            }
            is LoginUiEvent.NavigateToSignUpScreen -> {
                navController.navigateToSignUp()
            }
        }
    }
    LoginScreenContent(uiState, viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreenContent(
    uiState: LoginUiState,
    interaction: LoginInteraction,
) {
    val context = LocalContext.current
    uiState.error?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
    val imageBitmap: ImageBitmap =
        ImageBitmap.imageResource(context.resources, R.drawable.login)
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(SheetValue.Expanded)
    )
    when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            BottomSheetScaffold(
                sheetContent = { LoginContentPortrait(uiState, interaction) },
                scaffoldState = sheetState,
                sheetContainerColor = MaterialTheme.color.backgroundPrimary,
                sheetShape = RoundedCornerShape(
                    topStart = MaterialTheme.radius.radius32,
                    topEnd = MaterialTheme.radius.radius32
                ),
                sheetShadowElevation = MaterialTheme.spacing.spacing0,
                sheetPeekHeight = MaterialTheme.spacing.spacing32,
                sheetSwipeEnabled = false
            ) {
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

        else -> {
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
}

@Composable
private fun LoginContentPortrait(
    uiState: LoginUiState,
    interaction: LoginInteraction
) {
    Column(
        modifier = Modifier
            .padding(bottom = MaterialTheme.spacing.spacing12)
            .padding(horizontal = MaterialTheme.spacing.spacing24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.welcome_back),
            modifier = Modifier.align(Alignment.Start),
            style = Typography.headlineLarge.copy(fontSize = 24.sp),
            color = MaterialTheme.color.fontPrimary
        )
        Text(
            text = stringResource(R.string.login_to_your_account),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = MaterialTheme.spacing.spacing4),
            style = Typography.bodyMedium.copy(fontSize = 16.sp),
            color = MaterialTheme.color.fontPrimary
        )
        PrimaryTextField(
            value = uiState.userName,
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing24,
                bottom = MaterialTheme.spacing.spacing8),
            isError = uiState.isUserNameEmpty,
            leadingIcon = painterResource(id = R.drawable.icon_user),
            errorMessage = stringResource(R.string.invalid_username),
            text = stringResource(R.string.username),
            onClick = interaction::onUserNameChanged
        )
        val iconPassword = if (uiState.isPasswordVisible) R.drawable.icon_visibility_off
        else R.drawable.icon_visibility_on
        PrimaryTextField(
            value = uiState.password,
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.spacing24
            ),
            leadingIcon = painterResource(id = R.drawable.icon_password),
            trailingIcon = painterResource(iconPassword),
            onClickTrailingIcon = { interaction.onClickEyeIcon() },
            isError = uiState.isPasswordEmpty,
            errorMessage = "Invalid password",
            text = "Password",
            onClick = interaction::onPasswordChanged
        )
        Text(
            text = "Forget Password?",
            modifier = Modifier
                .align(Alignment.End)
                .padding(
                    top = MaterialTheme.spacing.spacing8,
                    bottom = MaterialTheme.spacing.spacing20
                ),
            style = Typography.labelSmall,
            color = MaterialTheme.color.fontSecondary
        )
        PrimaryButton(
//            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing20),
            onClick = { interaction.onClickLogin() },
            enabled = !uiState.isLoading,
            text = stringResource(R.string.login),
        )
        Row(
            modifier = Modifier
                .padding(vertical = MaterialTheme.spacing.spacing16),
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
                color = Color.White,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing8)
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
                width = MaterialTheme.dimens.dimens1,
                color = MaterialTheme.color.brand100
            ),
            text = "continue as a guest",
            textColor = MaterialTheme.color.brand100
        )
        AnimatedVisibility(uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
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
            text = "Login to your account",
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing4,
                bottom = MaterialTheme.spacing.spacing8
            ),
            style = Typography.displaySmall,
            color = MaterialTheme.color.fontPrimary
        )

        PrimaryTextField(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing16),
            value = uiState.userName,
            isError = uiState.isUserNameEmpty,
            leadingIcon = painterResource(id = R.drawable.icon_user),
            text = "Username",
            errorMessage = "Invalid Username",
            onClick = interaction::onUserNameChanged
        )
        val iconPassword = if (uiState.isPasswordVisible) R.drawable.icon_visibility_off
        else R.drawable.icon_visibility_on
        PrimaryTextField(
            value = uiState.password,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.spacing16)
                .padding(
                    top = MaterialTheme.spacing.spacing4,
                    bottom = MaterialTheme.spacing.spacing8
                ),
            leadingIcon = painterResource(id = R.drawable.icon_password),
            trailingIcon = painterResource(iconPassword),
            onClickTrailingIcon = { interaction.onClickEyeIcon() },
            isError = uiState.isPasswordEmpty,
            text = "Password",
            errorMessage = "Invalid Password",
            onClick = interaction::onPasswordChanged
        )

        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing16),
            onClick = { interaction.onClickLogin() },
            enabled = !uiState.isLoading,
            text = stringResource(R.string.login),
        )
        PrimaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.spacing12),
            onClick = { interaction.onClickGuest() },
            enabled = !uiState.isLoading,
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1,
                color = MaterialTheme.color.brand100
            ),
            text = "continue as a guest",
            textColor = MaterialTheme.color.brand100
        )
        AnimatedVisibility(uiState.isLoading) {
            CircularProgressIndicator(color = Color.White)
        }
    }

}


@Preview
@Composable
fun PreviewLoginScreen() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}

