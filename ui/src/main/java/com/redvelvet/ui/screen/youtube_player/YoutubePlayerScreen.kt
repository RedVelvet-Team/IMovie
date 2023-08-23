package com.redvelvet.ui.screen.youtube_player

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.youtube_player.YoutubePlayerViewModel

@Composable
fun YoutubePlayerScreen(
    viewModel: YoutubePlayerViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    YoutubePlayer(videoCode = state.videoCode,isPlayerLoading=state.isPlayerLoading)
}

@Composable
private fun YoutubePlayer(
    videoCode: String,
    isPlayerLoading :Boolean
) {
    val context = LocalContext.current
    val playerView = remember {
        YouTubePlayerView(context).apply {
            addYouTubePlayerListener(
                object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.cueVideo(videoCode, 0f)
                        (context as? Activity)?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    }
                }
            )
        }
    }

    AnimatedVisibility (!isPlayerLoading) {
        AndroidView(factory = { playerView })
    }
    AnimatedVisibility (isPlayerLoading)
    {
        LoadingState()
    }
}
