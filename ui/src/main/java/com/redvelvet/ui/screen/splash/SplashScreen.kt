package com.redvelvet.ui.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.onboarding.navigateToOnBoarding
import com.redvelvet.ui.theme.color

@Composable
fun SplashScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        MaterialTheme.color.backgroundPrimary,
        darkIcons = false
    )
    SplashContent()
}

@Composable
private fun SplashContent() {
    val navController = LocalNavController.current
    val rotationDegree = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit) {
        rotationDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 850)
        )
        navController.navigateToOnBoarding {
            popUpTo(MovieDestination.Splash.route) {
                inclusive = true
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector_logo),
            contentDescription = "Flix logo",
            modifier = Modifier.rotate(rotationDegree.value)
        )
    }
}