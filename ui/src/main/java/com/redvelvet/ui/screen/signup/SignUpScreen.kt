package com.redvelvet.ui.screen.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

private const val SIGNUP_LINK = "https://www.themoviedb.org/signup"

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SignUpScreen(
    navController: NavController,
) {
    val state = rememberWebViewState(SIGNUP_LINK)
    WebView(
        modifier = Modifier.fillMaxSize(),
        state = state,
        onCreated = { it.settings.javaScriptEnabled = true }
    )
}