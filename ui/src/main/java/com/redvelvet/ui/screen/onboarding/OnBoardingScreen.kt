package com.redvelvet.ui.screen.onboarding
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.MessageView
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.composable.WallPaper
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.screen.signup.navigateToSignUp
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.onboarding.OnBoardingInteractions
import com.redvelvet.viewmodel.onboarding.OnBoardingUiEvent
import com.redvelvet.viewmodel.onboarding.OnBoardingUiState
import com.redvelvet.viewmodel.onboarding.OnBoardingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            viewModel.event.collectLatest { event ->
                when (event) {
                    OnBoardingUiEvent.NavigateToLogin -> navController.navigateToLogin ()
                    OnBoardingUiEvent.NavigateToSignUpScreen -> navController.navigateToSignUp()
//                    OnBoardingUiEvent.NavigateTomHomeScreen -> navController.navigateToHome {
//                        popUpTo(MovieDestination.Login.route) {
//                            inclusive = true
//                        }
//                    }
                }
            }
        }
    }
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    OnBoardingContent(state = state, viewModel)
}

@Composable
private fun OnBoardingContent(
    state: OnBoardingUiState,
    interaction: OnBoardingInteractions,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        WallPaper(id = R.drawable.wallpaper)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MaterialTheme.spacing.spacing64),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MessageView(
                messageIcon = painterResource(id = R.drawable.vector_logo),
                messageTitle = stringResource(R.string.flixmovie),
                messageDescription = stringResource(R.string.description_about_app_in_onboarding),
                messageTitleStyle = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
                messageDescriptionStyle = Typography.titleSmall,
                spacingBetweenTitleAndImage = MaterialTheme.spacing.spacing16,
                spacingBetweenTitleAndDescription = MaterialTheme.spacing.spacing16,
            )
        }

        Column(
            modifier = Modifier.padding(
                bottom = MaterialTheme.spacing.spacing32,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrimaryButton(
                modifier = Modifier.fillMaxWidth()/*.padding(bottom = MaterialTheme.spacing.spacing32)*/,
                onClick = { interaction.onClickLogin() },
                enabled = !state.isLoading,
                text = stringResource(R.string.login),
            )
            PrimaryOutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.spacing12),
                onClick = { interaction.onClickSignUp() },
                enabled = !state.isLoading,
                border = BorderStroke(
                    width = MaterialTheme.dimens.dimens1,
                    color = MaterialTheme.color.brand100
                ),
                text = stringResource(R.string.sign_up),
                textColor = MaterialTheme.color.brand100
            )

//            TextButton(
//                onClick = { interaction.onClickGuest() },
//                modifier = Modifier,
//            ) {
//                Text(
//                    text = stringResource(id = R.string.continue_as_a_guest),
//                    style = Typography.headlineSmall,
//                    color = MaterialTheme.color.fontSecondary,
//                )
//            }
        }
    }
}

@Preview()
@Composable
fun TestTest() {
    OnBoardingScreen(navController = rememberNavController())
}