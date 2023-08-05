package com.redvelvet.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.WallPaper
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.onboarding.OnBoardingUiEvent
import com.redvelvet.viewmodel.onboarding.OnBoardingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Preview()
@Composable
fun TestTest() {
    OnBoardingScreen(navController = rememberNavController())
}

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
                    OnBoardingUiEvent.NavigateToLogin -> {
                        navController.navigateToLogin {
                            popUpTo(MovieDestination.OnBoarding.route) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
    }
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    OnBoardingContent {
        viewModel.setNotFirstTimeUseApp()
    }
}

@Composable
private fun OnBoardingContent(
    onStartClick: () -> Unit,
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
            Image(
                painter = painterResource(id = R.drawable.vector_logo),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier.size(
                    height = MaterialTheme.dimens.dimens78,
                    width = MaterialTheme.dimens.dimens78
                ),
            )
            Text(
                text = stringResource(R.string.name_app),
                style = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.spacing16),
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(R.string.description),
                style = Typography.titleSmall.copy(color = MaterialTheme.color.fontSecondary),
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing64)
        ) {
            PrimaryButton(
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens49)
                    .width(MaterialTheme.dimens.dimens100),
                text = stringResource(R.string.onboarding_start),
                onClick = { onStartClick() })
        }
    }
}
