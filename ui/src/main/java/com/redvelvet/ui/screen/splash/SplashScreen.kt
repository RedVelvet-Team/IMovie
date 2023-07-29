package com.redvelvet.ui.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import com.redvelvet.ui.theme.Primary
import com.redvelvet.viewmodel.SplashUiState
import com.redvelvet.viewmodel.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: SplashViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    val event = object : SplashUiEvent {
        override fun navigateToHome() {
            navigateTo(navController,MovieDestination.Home.route)
        }

        override fun navigateToOnBoarding() {
            navigateTo(navController,MovieDestination.OnBoarding.route)
        }

        override fun navigateToLogin() {
            navigateTo(navController,MovieDestination.Login.route)
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
    LaunchedEffect(key1 = Unit) {
        rotationDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 850)
        )
        delay(1500)
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
        modifier = Modifier.fillMaxSize(),
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

private fun navigateTo(navController: NavController,route: String){
    navController.navigate(route) {
        popUpTo(MovieDestination.Splash.route) {
            inclusive = true
        }
    }
}