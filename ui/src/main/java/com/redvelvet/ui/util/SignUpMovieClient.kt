package com.redvelvet.ui.util

import android.graphics.Bitmap
import android.webkit.WebView
import com.google.accompanist.web.AccompanistWebViewClient

class SignUpMovieClient(
    private val successUrlLink: String,
    private val onAccountCreationSuccess: () -> Unit,
) : AccompanistWebViewClient() {
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        if (url?.contains(successUrlLink) == true) {
            onAccountCreationSuccess()
            return
        }
        super.onPageStarted(view, url, favicon)
    }
}