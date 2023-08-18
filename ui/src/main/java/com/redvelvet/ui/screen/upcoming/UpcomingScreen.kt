package com.redvelvet.ui.screen.upcoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color

@Preview(showSystemUi = true)
@Composable
fun UpcomingScreen(){
    MovieScaffold(isLoading = false,title="Coming Soon", hasTopBar = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.color.backgroundPrimary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Coming Soon ...",
                style = Typography.bodyMedium,
                color = FontSecondary,
            )
        }
    }
}