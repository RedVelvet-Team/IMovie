package com.redvelvet.ui.screen.fun_activites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.GameItem
import com.redvelvet.ui.composable.ImageAndText
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.screen.room.navigateToCinemaRoom
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.ui.util.launchCollectLatest
import com.redvelvet.viewmodel.fun_activities.FunActivitiesUiEffect
import com.redvelvet.viewmodel.fun_activities.FunActivitiesViewModel

@Composable
fun FunScreen(
    viewModel: FunActivitiesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent)
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launchCollectLatest(viewModel.effect) { effect ->
            when (effect) {
                is FunActivitiesUiEffect.NavigateToCinemaRoom -> {
                    navController.navigateToCinemaRoom()
                }
            }
        }
    }
    FunContent({}, {})
}

@Composable
fun FunContent(
    onClickRoomItem: () -> Unit,
    onClickGameItem: () -> Unit
) {
    FlixMovieScaffold(
        isLoading = false,
        title = "Fun Activities",
        hasTopBar = true,
        hasBackArrow = true
    ) {
        Column(
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16,
                top = MaterialTheme.spacing.spacing34
            )
        ) {
            Text(
                modifier = Modifier.padding(top = MaterialTheme.spacing.spacing40),
                text = "Cinema room",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.color.fontPrimary
            )

            ImageAndText(
                painter = painterResource(id = R.drawable.room_placeholder),
                contentDescription = "room placeholder",
                title = "Share the Entertainment!",
                description = "You can create a room and invite your friends to watch movies together :)",
                onClick = onClickRoomItem,
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.spacing4)
                    .clickable { true }
            )
            Column(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.spacing12,
                    bottom = MaterialTheme.spacing.spacing12
                )
            ) {
                Text(
                    modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing12),
                    text = "Games",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.color.fontPrimary
                )
                GameItem(
                    modifier = Modifier
                        .padding(
                            top = MaterialTheme.spacing.spacing12,
                        )
                        .clickable { true },
                    onClick = onClickGameItem,
                    icon = ImageVector.vectorResource(R.drawable.ic_movie),
                    title = "Guess The Movie",
                    description = "In this game, we will show you a set of questions about movies, and you will have multiple options, and you have to choose a correct answer from among them"
                )
                SpacerVertical(height = MaterialTheme.spacing.spacing12)
                GameItem(
                    modifier = Modifier
                        .clickable { true },
                    onClick = onClickGameItem,
                    icon = ImageVector.vectorResource(R.drawable.ic_movie),
                    title = "Guess The TV Show",
                    description = "In this game, we will show you a set of questions about Tv shows, and you will have multiple options, and you have to choose a correct answer from among them"
                )
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewFunScreen() {
    FunScreen()
}