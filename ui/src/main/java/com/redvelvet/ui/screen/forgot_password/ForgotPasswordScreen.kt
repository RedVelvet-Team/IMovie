package com.redvelvet.ui.screen.forgot_password

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.WebViewWithListener
import com.redvelvet.ui.util.MovieWebViewUrls

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ForgotPasswordScreen() {
    val navController = LocalNavController.current
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar("Forgot Password", hasBackArrow = true)
        }
    ) {
        ForgotPasswordContent {
            Toast.makeText(context, "Password has been restored", Toast.LENGTH_SHORT)
                .show()
            navController.popBackStack()
        }
    }
}

@Composable
private fun ForgotPasswordContent(
    onSuccess: () -> Unit,
) {
    WebViewWithListener(
        url = MovieWebViewUrls.RESET_PASSWORD,
        successUrlLink = MovieWebViewUrls.CREATED_ACCOUNT_SUCCESS_URL
    ) {
        onSuccess()
    }
}