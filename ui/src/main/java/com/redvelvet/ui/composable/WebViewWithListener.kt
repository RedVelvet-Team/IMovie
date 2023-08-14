package com.redvelvet.ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import com.redvelvet.ui.util.SignUpMovieClient

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewWithListener(
    modifier: Modifier = Modifier,
    url: String,
    successUrlLink: String,
    onAccountCreationSuccess: () -> Unit
) {
    val state = rememberWebViewState(url = url)
    val webClient = remember {
        SignUpMovieClient(successUrlLink = successUrlLink) {
            onAccountCreationSuccess()
        }
    }
    WebView(
        modifier = modifier.fillMaxSize(),
        state = state,
        client = webClient,
        onCreated = { it.settings.javaScriptEnabled = true }
    )
}