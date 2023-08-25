package com.redvelvet.ui.screen.movie_player.composabels

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.Player.STATE_ENDED
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.ui.util.formatMinSec
import com.redvelvet.ui.util.setLandscape
import com.redvelvet.ui.util.setPortrait
import com.redvelvet.viewmodel.utils.formatDuration
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PlayerControls(
    modifier: Modifier = Modifier,
    isVisible: () -> Boolean,
    isPlaying: () -> Boolean,
    videoTimer: () -> Long,
    bufferedPercentage: () -> Int,
    playbackState: () -> Int,
    getTitle: () -> String,
    totalDuration: () -> Long,
    isFullScreen: Boolean,
    onPauseToggle: () -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onReplay: () -> Unit,
    onForward: () -> Unit,
    onSeekChanged: (newValue: Float) -> Unit,
    onFullScreenToggle: (isFullScreen: Boolean) -> Unit
) {

    val visible = remember(isVisible()) { isVisible() }

    val playing = remember(isPlaying()) { isPlaying() }

    val duration = remember(totalDuration()) { totalDuration().coerceAtLeast(0) }

    val timer = remember(videoTimer()) { videoTimer() }

    val title = remember(getTitle()) { getTitle() }

    val buffer = remember(bufferedPercentage()) { bufferedPercentage() }

    val playerState = remember(playbackState()) {
        playbackState()
    }

    val context = LocalContext.current

    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier
                .testTag("PlayerControlsParent")
                .background(MaterialTheme.color.backgroundPrimary.copy(alpha = 0.6f))
        ) {

            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
                    .testTag("VideoTitle")
                    .animateEnterExit(
                        enter = slideInVertically(
                            initialOffsetY = { fullHeight: Int -> -fullHeight }
                        ),
                        exit = shrinkVertically()
                    ),
                text = title.split("/").last(),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.color.fontPrimary
            )

            val controlButtonModifier: Modifier = remember(isFullScreen) {
                if (isFullScreen) {
                    Modifier
                        .padding(horizontal = 8.dp)
                        .size(40.dp)
                } else {
                    Modifier.size(32.dp)
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .testTag("VideoControlParent"),
                horizontalArrangement = if (isFullScreen) {
                    Arrangement.Center
                } else {
                    Arrangement.SpaceEvenly
                }
            ) {
                IconButton(
                    modifier = controlButtonModifier,
                    onClick = onPrevious
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id =R.drawable.icon_rewind_5_seconds_back),
                        contentDescription =""
                    )
                }

                IconButton(
                    modifier = controlButtonModifier,
                    onClick = onReplay
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.icon_rewind_5_seconds_forward),
                        contentDescription = ""
                    )
                }

                IconButton(
                    modifier = controlButtonModifier,
                    onClick = onPauseToggle
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(
                            id =
                            when {
                                playing -> {
                                   R.drawable.icon_pause
                                }
                                playing.not() && playerState == STATE_ENDED -> {
                                    R.drawable.icon_play
                                }
                                else -> {
                                    R.drawable.icon_play
                                }
                            }
                        ),
                        contentDescription = ""
                    )
                }

                IconButton(
                    modifier = controlButtonModifier,
                    onClick = onForward
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.icon_rewind_5_seconds_forward),
                        contentDescription = ""
                    )
                }

                IconButton(
                    modifier = controlButtonModifier,
                    onClick = onNext
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.icon_rewind_5_seconds_forward),
                        contentDescription = ""
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = if (isFullScreen) 32.dp else 16.dp)
                    .testTag("VideoSeek")
                    .animateEnterExit(
                        enter = slideInVertically(
                            initialOffsetY = { fullHeight: Int -> fullHeight }
                        ),
                        exit = slideOutVertically(
                            targetOffsetY = { fullHeight: Int -> fullHeight }
                        )
                    )
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Slider(
                        value = buffer.toFloat(),
                        enabled = false,
                        onValueChange = { /*do nothing*/ },
                        valueRange = 0f..100f,
                        colors =
                        SliderDefaults.colors(
                            disabledThumbColor = Color.Transparent,
                            disabledActiveTrackColor = MaterialTheme.color.backgroundOnPrimary
                        )
                    )

                    Slider(
                        value = timer.toFloat(),
                        onValueChange = {
                            onSeekChanged.invoke(it)
                        },
                        valueRange = 0f..duration.toFloat(),
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.color.backgroundPrimary,
                            activeTrackColor = MaterialTheme.color.backgroundPrimary
                        )
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .testTag("VideoTime")
                            .padding(start = 16.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    initialOffsetY = { fullHeight: Int -> fullHeight }
                                ),
                                exit = slideOutVertically(
                                    targetOffsetY = { fullHeight: Int -> fullHeight }
                                )
                            ),
                        text = duration.formatMinSec(),
                        color = MaterialTheme.color.backgroundPrimary,
                        style = MaterialTheme.typography.labelMedium
                    )

                    IconButton(
                        modifier = Modifier
                            .testTag("FullScreenToggleButton")
                            .padding(end = 16.dp)
                            .size(24.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    initialOffsetY = { fullHeight: Int -> fullHeight }
                                ),
                                exit = slideOutVertically(
                                    targetOffsetY = { fullHeight: Int -> fullHeight }
                                )
                            ),
                        onClick = {
                            if (isFullScreen.not()) {
                                context.setLandscape()
                            } else {
                                context.setPortrait()
                            }.also {
                                onFullScreenToggle.invoke(isFullScreen.not())
                            }
                        }
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(
                                id = if (isFullScreen) {
                                   R.drawable.icon_full_screen
                                } else {
                                    R.drawable.icon_full_screen                                }
                            ),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewPlayerControls() {
    PlayerControls(
        modifier = Modifier.fillMaxSize(),
        isVisible = { true },
        isPlaying = { true },
        videoTimer = { 0L },
        totalDuration = { 0 },
        bufferedPercentage = { 50 },
        isFullScreen = false,
        onForward = {},
        onNext = {},
        onPauseToggle = {},
        onPrevious = {},
        onReplay = {},
        onSeekChanged = {},
        onFullScreenToggle = {},
        getTitle = { "" },
        playbackState = { 1 }
    )
}






















//@OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)
//@Composable
//fun PlayerControls(
//    modifier: Modifier = Modifier,
//    isVisible: () -> Boolean,
//    isPlaying: () -> Boolean,
//    title: () -> String,
//    onReplayClick: () -> Unit,
//    onForwardClick: () -> Unit,
//    onPauseToggle: () -> Unit,
//    totalDuration: () -> Long,
//    currentTime: () -> Long,
//    bufferedPercentage: () -> Int,
//    onFullClickScreen: () -> Unit,
//    onSeekChanged: (timeMs: Float) -> Unit
//) {
//    val visible = remember(isVisible()) { isVisible() }
//
//    AnimatedVisibility(
//        modifier = modifier,
//        visible = visible,
//        enter = fadeIn(),
//        exit = fadeOut()
//    ) {
//        Box(modifier = Modifier.background(Color.Black.copy(alpha = 0.6f))) {
//            TopControl(
//                modifier = Modifier
//                    .align(Alignment.TopStart)
//                    .fillMaxWidth(), title = title
//            )
//            CenterControls(
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .fillMaxWidth(),
//                isPlaying = isPlaying,
//                onReplayClick = onReplayClick,
//                onForwardClick = onForwardClick,
//                onPauseToggle = onPauseToggle,
//            )
//            BottomControls(
//                modifier =
//                Modifier
//                    .align(Alignment.BottomCenter)
//                    .fillMaxWidth()
//                    .animateEnterExit(
//                        enter = slideInVertically(
//                            initialOffsetY = { fullHeight: Int -> fullHeight }),
//                        exit = slideOutVertically(targetOffsetY = { fullHeight: Int -> fullHeight })
//                    ),
//                totalDuration = totalDuration,
//                currentTime = currentTime,
//                bufferedPercentage = bufferedPercentage,
//                onSeekChanged = onSeekChanged,
//                onFullClick = onFullClickScreen
//            )
//        }
//    }
//}
//
//// region TopControl
//@Composable
//private fun TopControl(modifier: Modifier = Modifier, title: () -> String) {
//    val videoTitle = remember(title()) { title() }
//    Text(
//        modifier = modifier,
//        text = videoTitle,
//        style = MaterialTheme.typography.headlineMedium,
//        color = MaterialTheme.color.fontSecondary
//    )
//}
////endregion
//
//// region CenterControls
//@Composable
//private fun CenterControls(
//    modifier: Modifier = Modifier,
//    isPlaying: () -> Boolean,
//    onReplayClick: () -> Unit,
//    onPauseToggle: () -> Unit,
//    onForwardClick: () -> Unit
//) {
//    val isVideoPlaying = remember(isPlaying()) { isPlaying() }
//    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
//        IconButton(modifier = Modifier.size(40.dp), onClick = onReplayClick) {
//            Image(
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop,
//                painter = painterResource(id = R.drawable.icon_rewind_5_seconds_forward),
//                contentDescription = "Replay 5 seconds"
//            )
//        }
//        IconButton(modifier = Modifier.size(40.dp), onClick = onPauseToggle) {
//            Image(
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop,
//                painter =
//                if (isVideoPlaying) {
//                    painterResource(id = R.drawable.icon_pause)
//                } else {
//                    painterResource(id = R.drawable.icon_play)
//                }, contentDescription = "Play/Pause"
//            )
//        }
//        IconButton(modifier = Modifier.size(40.dp), onClick = onForwardClick) {
//            Image(
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop,
//                painter = painterResource(id = R.drawable.icon_rewind_5_seconds_forward),
//                contentDescription = "Forward 5 seconds"
//            )
//        }
//    }
//}
////endregion
//
//// region BottomControls
//@Composable
//private fun BottomControls(
//    modifier: Modifier = Modifier,
//    totalDuration: () -> Long,
//    currentTime: () -> Long,
//    bufferedPercentage: () -> Int,
//    onSeekChanged: (timeMs: Float) -> Unit,
//    onFullClick: () -> Unit
//) {
//    val duration = remember(totalDuration()) { totalDuration() }
//    val videoTime = remember(currentTime()) { currentTime() }
//    val buffer = remember(bufferedPercentage()) { bufferedPercentage() }
//
//    Column(modifier = modifier.padding(bottom = 32.dp)) {
//        Box(modifier = Modifier.fillMaxWidth()) {
//            Slider(
//                value = buffer.toFloat(),
//                enabled = false,
//                onValueChange = { /*do nothing*/ },
//                valueRange = 0f..100f,
//                colors =
//                SliderDefaults.colors(
//                    disabledThumbColor = Color.Transparent,
//                    disabledActiveTrackColor = Color.Gray
//                )
//            )
//            Slider(
//                modifier = Modifier.fillMaxWidth(),
//                value = videoTime.toFloat(),
//                onValueChange = onSeekChanged,
//                valueRange = 0f..duration.toFloat(),
//                colors =
//                SliderDefaults.colors(
//                    thumbColor = MaterialTheme.color.backgroundOnPrimary,
//                    activeTickColor = MaterialTheme.color.backgroundOnPrimary
//                )
//            )
//        }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = MaterialTheme.spacing.spacing16),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing16),
//                text = duration.formatDuration(),
//                color = MaterialTheme.color.backgroundOnPrimary
//            )
//            IconButton(
//                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing16),
//                onClick = onFullClick
//            ) {
//                Image(
//                    contentScale = ContentScale.Crop,
//                    painter = painterResource(id = R.drawable.icon_full_screen),
//                    contentDescription = "Enter/Exit fullscreen"
//                )
//            }
//        }
//    }
//}
////endregion