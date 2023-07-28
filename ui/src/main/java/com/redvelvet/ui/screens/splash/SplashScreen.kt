package com.redvelvet.ui.screens.splash

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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(viewModel: SplashViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    SplashContent(state)
}

@Composable
fun SplashContent(
    state: SplashUiState
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    val rotationDegree = remember { Animatable(0f) }
    LaunchedEffect(key1 = state) {
        rotationDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 850)
        )
        delay(1000)
//        if (!state.isLogged) {

//        } else {

//        }
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

//@Composable
//@Preview(showSystemUi = true)
//fun previewSplash() {
//    SplashScreen()
//}