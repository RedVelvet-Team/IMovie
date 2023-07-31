package com.redvelvet.ui.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.home.navigateToHome
import com.redvelvet.ui.screen.onboarding.navigateToOnBoarding
import com.redvelvet.ui.theme.Primary
import com.redvelvet.viewmodel.splash.SplashUiState
import com.redvelvet.viewmodel.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    val event = object : SplashUiEvent {
        override fun navigateToHome() {
            navController.navigateToHome {
                popUpTo(MovieDestination.Splash.route) {
                    inclusive = true
                }
            }
        }

        override fun navigateToOnBoarding() {
            navController.navigateToOnBoarding {
                popUpTo(MovieDestination.Splash.route) {
                    inclusive = true
                }
            }
        }

        override fun navigateToLogin() {
    //            navigateTo(navController, MovieDestination.Login.route)
        }
    }
    SplashContent(state, event)
}

@Composable
private fun SplashContent(
    state: SplashUiState,
    event: SplashUiEvent
) {
    val rotationDegree = remember { Animatable(0f) }
    LaunchedEffect(key1 = state) {
        rotationDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 850)
        )
        delay(1000)
        if (state.isFirstTimeUseApp) {
            event.navigateToOnBoarding()
            return@LaunchedEffect
        }
        if (state.isLogged || state.isGuest) {
            event.navigateToHome()
            return@LaunchedEffect
        }
        event.navigateToLogin()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_logo),
            contentDescription = null,
            modifier = Modifier.rotate(rotationDegree.value)
        )
    }
}