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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.screen.onboarding.navigateToOnBoarding
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.viewmodel.splash.SplashUiEvent
import com.redvelvet.viewmodel.splash.SplashUiState
import com.redvelvet.viewmodel.splash.SplashViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(BackgroundPrimary, darkIcons = false)
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launch {
            viewModel.event.collectLatest { event ->
                when (event) {
                    is SplashUiEvent.NavigateToHome -> {
                        navController.navigateToHome {
                            popUpTo(MovieDestination.Splash.route) {
                                inclusive = true
                            }
                        }
                    }

                    is SplashUiEvent.NavigateToOnBoarding -> {
                        navController.navigateToOnBoarding {
                            popUpTo(MovieDestination.Splash.route) {
                                inclusive = true
                            }
                        }
                    }

                    is SplashUiEvent.NavigateToLogin -> {
                        navController.navigateToLogin {
                            popUpTo(MovieDestination.Splash.route) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
    }
    SplashContent(state)
}

@Composable
private fun SplashContent(
    state: SplashUiState,
) {
    val rotationDegree = remember { Animatable(0f) }
    LaunchedEffect(key1 = state) {
        rotationDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 850)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary),
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