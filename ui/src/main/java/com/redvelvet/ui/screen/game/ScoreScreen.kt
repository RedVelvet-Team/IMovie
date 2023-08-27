package com.redvelvet.ui.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.game.GameScoreUiState
import com.redvelvet.viewmodel.game.GameScoreViewModel

@Composable
fun ScoreScreen(
    viewModel: GameScoreViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ScoreContent(state)
}

@Composable
private fun ScoreContent(state: GameScoreUiState) {

    val navController = LocalNavController.current
    FlixMovieScaffold(
        isLoading = state.isLoading,
        error = state.error
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (state.userInfo.name.isNotEmpty()){
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Your Score",
                    style = Typography.headlineLarge,
                    color = MaterialTheme.color.fontPrimary
                )
                PlayerCard(
                    name = state.userInfo.name,
                    score = state.userInfo.score,
                    modifier = Modifier.padding(bottom = 44.dp)
                )
            }
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Highest Score",
                style = Typography.headlineLarge,
                color = MaterialTheme.color.fontPrimary
            )
            repeat(state.highestScorePlayer.size){
                val player = state.highestScorePlayer[it]
                PlayerCard(name = player.name, score = player.score)
            }

            PrimaryButton(onClick = {navController.navigateToGameScreen()}, text = "Play Now")

        }
    }

}

@Composable
fun PlayerCard(
    name: String,
    score: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Secondary)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            color = FontPrimary
        )
        Text(
            text = score,
            style = Typography.headlineSmall,
            color = FontPrimary
        )
    }
}