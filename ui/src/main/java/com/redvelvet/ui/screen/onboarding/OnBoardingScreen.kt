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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.MessageView
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.composable.WallPaper
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.home.navigateToHome
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.screen.movie_player.navigateMoviePlayer
import com.redvelvet.ui.screen.room.navigateToCinemaRoom
import com.redvelvet.ui.screen.signup.navigateToSignUp
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.onboarding.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val navController = LocalNavController.current
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        MaterialTheme.color.backgroundPrimary, darkIcons = false
    )
    LaunchedEffect(key1 = Unit) {
        if (state.loggedIn) {
            navController.navigateToHome {
                popUpTo(MovieDestination.OnBoarding.route) {
                    inclusive = true
                }
            }
        }
    }
// (id = "100", type = SeeAllTvShows.TOP_RATED)
    OnBoardingContent(
        onClickLogin = { navController.navigateToCinemaRoom() },
        onClickSignUp = { navController.navigateToSignUp() }
    )
}

@Composable
private fun OnBoardingContent(
    onClickLogin: () -> Unit,
    onClickSignUp: () -> Unit,
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
                messageTitle = "FlixMovie",
                messageDescription = "Enjoy a seamless and user-friendly experience Browse movies " +
                        "effortlessly and watch them instantly online.",
                messageTitleStyle = Typography.headlineLarge.copy(
                    color = MaterialTheme.color.fontPrimary
                ),
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
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickLogin,
                text = "Login",
            )
            PrimaryOutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.spacing12),
                onClick = onClickSignUp,
                border = BorderStroke(
                    width = MaterialTheme.dimens.dimens1, color = MaterialTheme.color.brand100
                ),
                text = "SignUp",
                textColor = MaterialTheme.color.brand100
            )
        }
    }
}