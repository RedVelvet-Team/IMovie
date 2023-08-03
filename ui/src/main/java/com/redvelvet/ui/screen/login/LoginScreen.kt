package com.redvelvet.ui.screen.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomDivider
import com.redvelvet.ui.composable.PasswordTextField
import com.redvelvet.ui.composable.ProgressIndicator
import com.redvelvet.ui.composable.SpacerHorizontal
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.composable.TextLoginScreen
import com.redvelvet.ui.composable.UserNameTextField
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.home.navigateToHome
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.viewmodel.login.LoginInteraction
import com.redvelvet.viewmodel.login.LoginUiEvent
import com.redvelvet.viewmodel.login.LoginUiState
import com.redvelvet.viewmodel.login.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    val uiState by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            viewModel.event.collectLatest {
                when (it) {
                    is LoginUiEvent.NavigateTomHomeScreen -> navController.navigateToHome {
                        popUpTo(MovieDestination.Login.route) {
                            inclusive = true
                        }
                    }
                }
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
                sheetContainerColor = Primary,
                sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                sheetShadowElevation = 0.dp,
                sheetPeekHeight = 32.dp,
                sheetSwipeEnabled = false
            ) {
                Image(
                    bitmap = imageBitmap,
                    contentDescription = stringResource(R.string.login_image),
                    modifier = Modifier
                        .height(365.dp)
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
                    contentDescription = stringResource(R.string.login_image),
                    modifier = Modifier
                        .height(365.dp)
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
        modifier = Modifier.padding(top = 0.dp, start = 24.dp, end = 24.dp, bottom = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextLoginScreen(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(R.string.welcome_back),
            fontWeight = FontWeight.SemiBold,
            size = 18.sp
        )
        SpacerVertical(height = 4.dp)
        TextLoginScreen(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(R.string.login_to_your_account),
            fontWeight = FontWeight.Normal,
            size = 12.sp
        )
        SpacerVertical(height = 24.dp)
        UserNameTextField(
            value = uiState.userName,
            isError = uiState.isUserNameEmpty,
            text = stringResource(R.string.username),
            onClick = interaction::onUserNameChanged
        )

        SpacerVertical(height = 24.dp)

        PasswordTextField(
            value = uiState.password,
            isError = uiState.isPasswordEmpty,
            text = stringResource(R.string.password),
            onClick = interaction::onPasswordChanged
        )

        SpacerVertical(height = 24.dp)

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !uiState.isLoading,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple100)
        ) {
            TextLoginScreen(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.login),
                fontWeight = FontWeight.SemiBold,
                size = 14.sp
            )
        }

        SpacerVertical(height = 24.dp)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomDivider(modifier = Modifier.weight(1f))
            Text(
                stringResource(R.string.or),
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            CustomDivider(modifier = Modifier.weight(1f))
        }

        SpacerVertical(height = 24.dp)

        GuestOrSignUp(!uiState.isLoading, interaction::onClickGuest)
        if (uiState.isLoading) {
            ProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
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
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextLoginScreen(
            modifier = Modifier.padding(top = 24.dp),
            text = stringResource(R.string.welcome_back),
            fontWeight = FontWeight.SemiBold,
            size = 18.sp
        )

        SpacerVertical(height = 4.dp)

        TextLoginScreen(
            modifier = Modifier,
            text = stringResource(R.string.login_to_your_account),
            fontWeight = FontWeight.Normal,
            size = 12.sp
        )

        SpacerVertical(height = 8.dp)

        UserNameTextField(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = uiState.userName,
            isError = uiState.isUserNameEmpty,
            text = stringResource(R.string.username),
            onClick = interaction::onUserNameChanged
        )

        PasswordTextField(
            value = uiState.password,
            modifier = Modifier.padding(horizontal = 16.dp),
            isError = uiState.isPasswordEmpty,
            text = stringResource(R.string.password),
            onClick = interaction::onPasswordChanged
        )

        SpacerVertical(height = 8.dp)

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(56.dp),
            enabled = !uiState.isLoading,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple100)
        ) {
            TextLoginScreen(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.login),
                fontWeight = FontWeight.SemiBold,
                size = 14.sp
            )
        }

        SpacerVertical(height = 8.dp)

        GuestOrSignUp(!uiState.isLoading, interaction::onClickGuest)

        if (uiState.isLoading) {
            ProgressIndicator(modifier = Modifier)
        }
    }
}

@Composable
private fun GuestOrSignUp(
    isLoading: Boolean,
    onGuestClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextButton(
            onClick = { onGuestClicked() },
            modifier = Modifier
                .height(56.dp)
                .border(1.dp, Purple100, shape = MaterialTheme.shapes.medium)
        ) {
            TextLoginScreen(
                text = stringResource(R.string.continue_as_a_guest),
                fontWeight = FontWeight.SemiBold,
                size = 14.sp
            )
        }
        SpacerHorizontal(width = 8.dp)
        //TODO onSignUpClicked()
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(56.dp),
            enabled = isLoading,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple100)
        ) {
            TextLoginScreen(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(R.string.signup),
                fontWeight = FontWeight.SemiBold,
                size = 14.sp
            )
        }
    }
}

