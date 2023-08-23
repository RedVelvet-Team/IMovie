package com.redvelvet.ui.screen.episode

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.theme.color

@Composable
fun EpisodeDetailsScreen() {
    val navController = LocalNavController.current
    val context = LocalContext.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)

}

@Composable
private fun EpisodeDetailsContent(

) {

}