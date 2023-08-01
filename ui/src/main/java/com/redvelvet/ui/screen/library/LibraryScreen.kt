package com.redvelvet.ui.screen.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomButton
import com.redvelvet.ui.composable.CustomText
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Typography

@Composable
fun LibraryScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.library_title_screen),
                hasBackArrow = false,
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = Primary,
    ) { paddingValues ->
        LibraryContent(paddingValues = paddingValues)
    }
}

@Composable
private fun LibraryContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 58.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.library_logo),
            contentDescription = stringResource(R.string.library_logo)
        )
        CustomText(
            name = stringResource(R.string.login_require_header),
            modifier = Modifier.padding(top = 32.dp),
            style = Typography.headlineLarge.copy(color = FontPrimary),
        )
        CustomText(
            name = stringResource(R.string.login_require_description),
            modifier = Modifier.padding(top = 4.dp),
            style = Typography.titleSmall.copy(color = FontSecondary),
        )
        Column(
            modifier = Modifier.padding(top = 32.dp)
        ) {
            CustomButton(
                text = stringResource(R.string.login_require_button),
                onClick = { /*TODO*/ },
            )
        }
    }
}