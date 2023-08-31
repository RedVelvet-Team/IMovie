package com.redvelvet.ui.screen.game

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.DialogWithIcon
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.screen.game.composable.InstructionCard
import com.redvelvet.ui.screen.game.composable.PlayerCard
import com.redvelvet.ui.screen.game.composable.UserInfoCard
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.game.GameScoreUiEffect
import com.redvelvet.viewmodel.game.GameScoreUiState
import com.redvelvet.viewmodel.game.GameDetailsViewModel

@Composable
fun GameDetailsScreen(
    viewModel: GameDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is GameScoreUiEffect.NavigateToQuestionsScreen -> navController.navigateToQuestionsScreen()
            }
        }
    )
    FlixMovieScaffold(
        isLoading = state.isLoading, error = state.error, hasTopBar = true, title = "Game Details"
    ) {
        GameDetailsContent(
            state = state,
            onClickPlay = viewModel::onClickPlay,
            onClickCancel = viewModel::onClickCancel,
        )
    }
}

@SuppressLint("ResourceType")
@Composable
private fun GameDetailsContent(
    state: GameScoreUiState, onClickPlay: () -> Unit, onClickCancel: () -> Unit
) {
    val navController = LocalNavController.current
    AnimatedVisibility(visible = !state.canJoinGame) {
        DialogWithIcon(
            showDialogState = true,
            submitText = "Login",
            onSubmitClick = { navController.navigateToLogin() },
            onClickCancel = onClickCancel
        )
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(80.dp))
            AnimatedVisibility(visible = state.userInfo.name.isNotEmpty()) {
                Image(
                    modifier = Modifier.size(88.dp),
                    painter = painterResource(id = 2131230911),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 12.dp),
                    text = state.userInfo.name,
                    style = Typography.titleMedium,
                    color = MaterialTheme.color.fontPrimary
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    UserInfoCard(
                        title = "Points",
                        iconPainter = painterResource(id = R.drawable.ic_point),
                        text = state.userInfo.score
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    UserInfoCard(
                        title = "Rank",
                        iconPainter = painterResource(id = R.drawable.ic_medal),
                        text = state.userInfo.rank.toString()
                    )
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                text = "Instructions",
                style = Typography.headlineLarge,
                color = MaterialTheme.color.fontPrimary
            )

            InstructionCard(
                iconPainter = painterResource(id = R.drawable.ic_like),
                instruction = "Correct answers earn points.\n" + "more levels = more points."
            )
            InstructionCard(
                iconPainter = painterResource(id = R.drawable.ic_dislike),
                instruction = "You have only 3 chances for wrong answers."
            )
            InstructionCard(
                iconPainter = painterResource(id = R.drawable.ic_ranking),
                instruction = "Earn more points to show up in ranking list!"
            )
            InstructionCard(
                iconPainter = painterResource(id = R.drawable.ic_gamebad),
                instruction = "Enjoy the challenge, and have fun!"
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                text = "Top ${state.highestScorePlayer.size}",
                style = Typography.headlineLarge,
                color = MaterialTheme.color.fontPrimary
            )
            repeat(state.highestScorePlayer.size) {
                val player = state.highestScorePlayer[it]
                PlayerCard(
                    name = player.name,
                    score = player.score,
                    iconPainter = painterResource(id = player.avatarId),
                )
            }
            Spacer(modifier = Modifier.height(120.dp))
        }
        PrimaryButton(
            modifier = Modifier
                .height(90.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Secondary)
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                onClickPlay()
            }, text = "Play Now"
        )
    }
}

