package com.redvelvet.ui.screen.room

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.DialogWithLink
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.composable.WallPaper
import com.redvelvet.ui.screen.movie_player.navigateMoviePlayer
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.ui.util.launchCollectLatest
import com.redvelvet.viewmodel.room.Clicked
import com.redvelvet.viewmodel.room.RoomInteractions
import com.redvelvet.viewmodel.room.RoomUiEffect
import com.redvelvet.viewmodel.room.RoomUiState
import com.redvelvet.viewmodel.room.RoomViewModel

@Composable
fun RoomScreen(
    viewModel: RoomViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    val scope = rememberCoroutineScope()

    systemUiController.setSystemBarsColor(Color.Transparent)

    LaunchedEffect(key1 = Unit) {
        scope.launchCollectLatest(viewModel.effect) { effect ->
            when (effect) {
                is RoomUiEffect.NavigateToVideoPlayer -> {
                    navController.navigateMoviePlayer(effect.roomUrl)
                }
            }
        }
    }
    AnimatedVisibility(visible = state.dialogState.showDialog) {
        DialogWithLink(
            headText = "Join cinema room",
            bodyText = "You can join room by adding the link of the room",
            placeHolderText = "Room Link",
            submitText = "Done",
            isError = state.dialogState.isError,
            showDialogState = state.dialogState.showDialog,
            link = state.dialogState.roomUrl,
            onTextChange = { newLink -> viewModel.updateRoomUrl(newLink) },
            onSubmitClick = viewModel::onClickSubmit,
            onClickCancel = viewModel::onClickCancel
        )
    }

    RoomContent(state, viewModel)
}

@Composable
fun RoomContent(state: RoomUiState, listener: RoomInteractions) {
    FlixMovieScaffold(
        isLoading = state.isLoading,
        hasBackArrow = true,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            WallPaper(id = R.drawable.room_background)
            Column(
                modifier = Modifier.padding(
                    start = MaterialTheme.spacing.spacing16,
                    end = MaterialTheme.spacing.spacing16,
                    bottom = MaterialTheme.spacing.spacing24,
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        listener.onClickCreateRoom()
                    },
                    buttonColor = MaterialTheme.color.brand60,
                    text = "Create Room",
                    textColor = MaterialTheme.color.fontSecondary
                )
                SpacerVertical(height = MaterialTheme.spacing.spacing12)
                PrimaryOutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        listener.onClickJoinRoom()
                    },
                    enabled = !state.isLoading,
                    border = BorderStroke(
                        width = MaterialTheme.dimens.dimens1,
                        color = MaterialTheme.color.brand60
                    ),
                    text = "Join Room",
                    textColor = MaterialTheme.color.brand100
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RoomPreview() {
    RoomScreen()
}


