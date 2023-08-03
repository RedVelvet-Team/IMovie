package com.redvelvet.ui.screen.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomTopAppBar

private const val SIGNUP_LINK = "https://www.themoviedb.org/signup"

@SuppressLint("SetJavaScriptEnabled", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    navController: NavController,
) {
    val state = rememberWebViewState(SIGNUP_LINK)
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar(stringResource(id = R.string.signup), hasBackArrow = false)
        }
    ) {
        WebView(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onCreated = { it.settings.javaScriptEnabled = true }
        )
    }
}