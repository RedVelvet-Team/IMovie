package com.redvelvet.ui.composable

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.base.InvalidationErrorState
import com.redvelvet.viewmodel.base.NetworkErrorState
import com.redvelvet.viewmodel.base.NullResultErrorState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FlixMovieScaffold(
    modifier: Modifier = Modifier,
    title: String = "",
    isLoading: Boolean,
    onLoading: @Composable () -> Unit = { LoadingState() },
    error: ErrorUiState? = null,
    onError: @Composable () -> Unit = {},
    onRetry: @Composable () -> Unit = {},
    onClick: () -> Unit = {},
    hasBackArrow: Boolean = true,
    hasTopBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary),
        topBar = {
            AnimatedVisibility(visible = hasTopBar) {
                FilxTopAppBar(
                    title = title,
                    hasBackArrow = hasBackArrow
                )
            }
        },
        containerColor = Color.Transparent
    ) { _ ->
        AnimatedVisibility(
            visible = isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            onLoading()
        }
        AnimatedVisibility(
            visible = error != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            ErrorAnimatedHandler(error ?: ErrorUiState(""), onError, onRetry, onClick)
        }
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            MaterialTheme.color.backgroundPrimary,
            darkIcons = false
        )
        AnimatedVisibility(
            visible = !isLoading && (error == null),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            content()
        }

    }
}

@Composable
fun ErrorAnimatedHandler(
    error: ErrorUiState,
    onError: @Composable () -> Unit = {},
    onRetry: @Composable () -> Unit,
    onClick: () -> Unit = {},
) {
    ErrorViewer(error, onError, onRetry, onClick)
}

@Composable
fun ErrorViewer(
    error: ErrorUiState,
    onError: @Composable () -> Unit = {},
    retryButton: @Composable () -> Unit = {},
    onClick: () -> Unit = {},
) {
    when (error) {
        is NullResultErrorState -> NoContent(retryButton = retryButton)
        is InvalidationErrorState -> LoginRequired(retryButton = retryButton)
        is NetworkErrorState -> NetworkView(onClick = onClick)
        else -> onError()
    }
}

@Composable
fun NetworkView(onClick: () -> Unit = {}) {
    ErrorPage(
        image = painterResource(id = R.drawable.vector_no_internet),
        title = "Internet is not available",
        description = "please make sure you are connected to the internet and try again",
        retryButton = {
            PrimaryButton(
                onClick = { onClick() },
                text = "Try Again",
            )
        }
    )
}

@Composable
fun LoginRequired(retryButton: @Composable () -> Unit = {}) {
    ErrorPage(
        image = painterResource(id = R.drawable.library_logo),
        title = "Login Required",
        description = "Use you account to enjoy the best app experience",
        retryButton = retryButton,
    )
}

@Composable
fun NoContent(
    title: String = "There are no favorite",
    description: String = "Enjoy adding items to your favorites list and get ready to enjoy",
    retryButton: @Composable () -> Unit = {}
) {
    ErrorPage(
        image = painterResource(id = R.drawable.vector_not_found),
        title = title,
        description = description,
        retryButton = retryButton
    )
}


@Composable
fun ErrorPage(
    image: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    retryButton: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.dimens.dimens58),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = image,
            contentDescription = title
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.dimens.dimens32),
            text = title,
            style = Typography.labelLarge,
            color = MaterialTheme.color.fontSecondary
        )
        Text(
            modifier = Modifier.padding(
                top = MaterialTheme.dimens.dimens4,
                bottom = MaterialTheme.dimens.dimens48
            ),
            text = description,
            style = Typography.displaySmall,
            color = MaterialTheme.color.fontAccent,
            textAlign = TextAlign.Center,
        )
        retryButton()
    }
}