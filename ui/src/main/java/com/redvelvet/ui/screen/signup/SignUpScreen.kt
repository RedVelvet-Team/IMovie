package com.redvelvet.ui.screen.signup

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
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.login.navigateToLogin

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
) {
    val navController = LocalNavController.current
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar("Sign Up", hasBackArrow = true)
        }
    ) {
        WebViewWithListener(
            url = "https://www.themoviedb.org/signup",
            successUrlLink = "https://www.themoviedb.org/u/"
        ) {
            Toast.makeText(context, "Account has been created", Toast.LENGTH_SHORT)
                .show()
            navController.navigateToLogin {
                popUpTo(MovieDestination.SignUp.route) {
                    inclusive = true
                }
            }
        }
    }
}
