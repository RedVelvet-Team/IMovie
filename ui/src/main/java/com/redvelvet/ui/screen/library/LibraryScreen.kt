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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing

@Composable
fun LibraryScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                title = stringResource(R.string.library_title_screen),
                hasBackArrow = false,
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = BackgroundPrimary,
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
            contentDescription = stringResource(R.string.library_logo)
        )
        Text(
            text = stringResource(R.string.login_require_header),
            style = Typography.headlineLarge.copy(color = FontPrimary),
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32),
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(R.string.login_require_description),
            style = Typography.titleSmall.copy(color = FontSecondary),
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4),
            textAlign = TextAlign.Center,
        )

        Column(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32)
        ) {
            PrimaryButton(
                text = stringResource(R.string.login_require_button),
                onClick = { /*TODO*/ },
            )
        }
    }
}