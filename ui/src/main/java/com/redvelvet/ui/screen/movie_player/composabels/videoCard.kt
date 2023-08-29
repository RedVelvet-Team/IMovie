package com.redvelvet.ui.screen.movie_player.composabels

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.Player.STATE_ENDED
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.util.Constants
import com.redvelvet.ui.util.setPortrait


import kotlinx.coroutines.delay

@Composable
fun CustomPlayerView(
    modifier: Modifier = Modifier,
    playerWrapper: Player,
    isFullScreen: Boolean,
    onTrailerChange: ((Int) -> Unit)? = null,
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit,
    shouldShowControls:Boolean = false
) {
    val context = LocalContext.current

    BackHandler {
        if (isFullScreen) {
            context.setPortrait()
            onFullScreenToggle.invoke(false)
        }
    }

    Box(modifier = modifier) {

        var isPlaying by remember { mutableStateOf(playerWrapper.isPlaying) }

        var playbackState by remember { mutableStateOf(playerWrapper.playbackState) }

        var title by remember {
            mutableStateOf(playerWrapper.currentMediaItem?.mediaMetadata?.displayTitle.toString())
        }

        var videoTimer by remember { mutableStateOf(0L) }

        var totalDuration by remember { mutableStateOf(0L) }

        var bufferedPercentage by remember { mutableStateOf(0) }

        LaunchedEffect(key1 = shouldShowControls) {
            if (shouldShowControls) {
                delay(Constants.PLAYER_CONTROLS_VISIBILITY)
                shouldShowControls
            }
        }

        DisposableEffect(key1 = true) {
            val listener = object : Player.Listener {
                override fun onEvents(player: Player, events: Player.Events) {
                    super.onEvents(player, events)
                    isPlaying = player.isPlaying
                    totalDuration = player.duration
                    videoTimer = player.contentPosition
                    bufferedPercentage = player.bufferedPercentage
                    playbackState = player.playbackState
                }

                override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                    super.onMediaItemTransition(mediaItem, reason)
                    onTrailerChange?.invoke(playerWrapper.currentPeriodIndex)
                    title = mediaItem?.mediaMetadata?.displayTitle.toString()
                }
            }

            playerWrapper.addListener(listener)

            onDispose {
                playerWrapper.removeListener(listener)
            }
        }

        VideoPlayer(
            modifier = Modifier.fillMaxSize(),
            playerWrapper = playerWrapper,
            onPlayerClick = { shouldShowControls.not() }
        )

        PlayerControls(
            modifier = Modifier.fillMaxSize(),
            isVisible = { shouldShowControls },
            isPlaying = { isPlaying },
            playbackState = { playbackState },
            totalDuration = { totalDuration },
            bufferedPercentage = { bufferedPercentage },
            getTitle = { title },
            isFullScreen = isFullScreen,
            onPrevious = { playerWrapper.seekToPrevious() },
            onNext = { playerWrapper.seekToNext() },
            onReplay = { playerWrapper.seekBack() },
            onForward = { playerWrapper.seekForward() },
            onPauseToggle = {
                when {
                    playerWrapper.isPlaying -> {
                        playerWrapper.pause()
                    }
                    playerWrapper.isPlaying.not() && playbackState == STATE_ENDED -> {
                        playerWrapper.seekTo(0, 0)
                        playerWrapper.playWhenReady = true
                    }
                    else -> {
                        playerWrapper.play()
                    }
                }
                isPlaying = isPlaying.not()
            },
            onSeekChanged = { position -> playerWrapper.seekTo(position.toLong()) },
            videoTimer = { videoTimer },
            onFullScreenToggle = onFullScreenToggle
        )
    }
}

@Composable
private fun VideoPlayer(
    modifier: Modifier = Modifier,
    playerWrapper: Player,
    onPlayerClick: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .background(MaterialTheme.color.backgroundOnPrimary)
            .testTag("VideoPlayerParent")
            .clickable {
                onPlayerClick.invoke()
            }
    ) {
        AndroidView(
            modifier = modifier
                .testTag("VideoPlayer"),
            factory = {
                PlayerView(context).apply {
                    player = playerWrapper
                    useController = false
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlayerView() {
    val context = LocalContext.current
    CustomPlayerView(
        modifier = Modifier.fillMaxSize(),
        playerWrapper =ExoPlayer.Builder(context).build(),
        isFullScreen = false,
        onFullScreenToggle = {}
    )
}
