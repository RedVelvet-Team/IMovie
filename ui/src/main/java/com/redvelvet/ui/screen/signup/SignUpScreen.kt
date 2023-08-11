package com.redvelvet.ui.screen.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.redvelvet.ui.composable.FilxTopAppBar

private const val SIGNUP_LINK = "https://www.themoviedb.org/signup"

@SuppressLint("SetJavaScriptEnabled", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
) {
    val state = rememberWebViewState(SIGNUP_LINK)
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar("Sign Up", hasBackArrow = false)
        }
    ) {
        WebView(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onCreated = { it.settings.javaScriptEnabled = true }
        )
    }
}