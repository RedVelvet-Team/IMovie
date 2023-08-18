package com.redvelvet.ui.screen.room

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.room.RoomUiState
import com.redvelvet.viewmodel.room.RoomViewModel

@Composable
fun RoomScreen(
    viewModel: RoomViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        Color.Transparent
    )
    RoomContent(state = state,
        onClickCreateRoom = {},
        onClickJoinRoom = {})
}

@Composable
fun RoomContent(
    state: RoomUiState,
    onClickCreateRoom: () -> Unit,
    onClickJoinRoom: () -> Unit,
) {
    val imageBitmap: ImageBitmap = ImageBitmap.imageResource(R.drawable.room_background)

    MovieScaffold(
        isLoading = state.isLoading,
        hasBackArrow = true,
    ) {
        Box {
            Image(
                bitmap = imageBitmap,
                contentDescription = "Room Image",
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens365)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}
