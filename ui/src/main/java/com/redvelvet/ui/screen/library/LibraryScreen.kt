package com.redvelvet.ui.screen.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing

@Composable
fun LibraryScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                title = "Library",
                hasBackArrow = false,
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = MaterialTheme.color.backgroundPrimary,
    ) { paddingValues ->
        LibraryContent(paddingValues = paddingValues)
    }
}

@Composable
private fun LibraryContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MaterialTheme.spacing.spacing58),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.library_logo),
            contentDescription = "library logo"
        )
        Text(
            text = "Login Required",
            style = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32),
            textAlign = TextAlign.Center,
        )
        Text(
            text = "Use your account to enjoy the best app experience.",
            style = Typography.titleSmall.copy(color = MaterialTheme.color.fontSecondary),
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4),
            textAlign = TextAlign.Center,
        )

        Column(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32)
        ) {
            PrimaryButton(
                text = "Login",
                onClick = { /*TODO*/ },
            )
        }
    }
}