package com.redvelvet.ui.screen.movie_player

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.C
import androidx.media3.common.MediaItem.fromUri
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.screen.movie_player.composabels.CustomPlayerView
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.util.Constants.PLAYER_SEEK_BACK_INCREMENT
import com.redvelvet.ui.util.Constants.PLAYER_SEEK_FORWARD_INCREMENT
import com.redvelvet.viewmodel.movie_player.MoviePlayerViewModel


@Composable
fun MoviePlayerScreen(
    viewModel: MoviePlayerViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)

    ShowVideo(
        videoUrl= state.videoUrl ,
        onFullScreenToggle={}
    )
}
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@SuppressLint("RememberReturnType")
@Composable
private fun ShowVideo(
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit,
    videoUrl:String
) {

    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .setSeekBackIncrementMs(PLAYER_SEEK_BACK_INCREMENT)
            .setSeekForwardIncrementMs(PLAYER_SEEK_FORWARD_INCREMENT)
            .build().apply {
                this.setMediaItem(fromUri(videoUrl))
                this.prepare()
                this.playWhenReady = true
            }
    }

    exoPlayer.setMediaItem(fromUri(videoUrl))
    Log.d("Kosomk",videoUrl)

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    DisposableEffect(key1 = Unit) {
        val observer = object : DefaultLifecycleObserver {
            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                if (exoPlayer.isPlaying.not()) {
                    exoPlayer.play()
                }
            }

            override fun onStop(owner: LifecycleOwner) {
                exoPlayer.pause()
                super.onStop(owner)
            }
        }

        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
            exoPlayer.release()
        }
    }

    Video(
        playerWrapper = exoPlayer,
        onFullScreenToggle = onFullScreenToggle,
    )
}

@Composable
private fun Video(
    playerWrapper: Player,
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit,
) {

    val configuration = LocalConfiguration.current

    var playingIndex by remember {
        mutableStateOf(0)
    }

    fun onTrailerChange(index: Int) {
        playingIndex = index
        playerWrapper.seekTo(playingIndex, C.TIME_UNSET)
        playerWrapper.playWhenReady = true
    }

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            PortraitView(
                playerWrapper = playerWrapper,
                onTrailerChange = { index -> onTrailerChange(index) },
                onFullScreenToggle = onFullScreenToggle,
            )
        }
        else -> {
            LandscapeView(
                playerWrapper = playerWrapper,
                onFullScreenToggle = onFullScreenToggle
            )
        }
    }
}
@Composable
private fun PortraitView(
    playerWrapper: Player,
    onTrailerChange: (Int) -> Unit,
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit,
) {
    Column(modifier = Modifier
        .systemBarsPadding()
        .background(MaterialTheme.color.backgroundPrimary)) {
        CustomPlayerView(
            playerWrapper = playerWrapper,
            isFullScreen = false,
            onTrailerChange = onTrailerChange,
            onFullScreenToggle = onFullScreenToggle,
        )
    }
}

@Composable
private fun LandscapeView(
    playerWrapper: Player,
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.color.backgroundPrimary)) {
        CustomPlayerView(
            modifier = Modifier.fillMaxSize(),
            playerWrapper = playerWrapper,
            isFullScreen = true,
            onFullScreenToggle = onFullScreenToggle
        )
    }
}
