package com.redvelvet.ui.screen.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.SecondaryCard2
import com.redvelvet.ui.theme.SecondaryCard3
import com.redvelvet.viewmodel.game.GameUiState
import com.redvelvet.viewmodel.game.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    GameContent(state)
}

@Composable
fun GameContent(state: GameUiState) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        RepeatableCardStack(listOf())
    }
}

@Composable
fun RepeatableCardStack(
    questions: List<String>
) {
    repeat(questions.size) {index ->
        Card(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = 16.dp)
                .rotate(
                    when(2-index){
                        0 -> 0f
                        1 -> 5f
                        2 -> -5f
                        else -> -5f
                    }
                )
                .alpha(if (2-index == 0) 1f else .2f),
            colors = CardDefaults.cardColors(containerColor = when(2 - index){
                0 -> Secondary
                1 -> SecondaryCard2
                3 -> SecondaryCard3
                else -> Color.Green
            }
            )
        ) {
//            Text(
//                modifier = Modifier.fillMaxSize(),
//                text = "This is a Question ??",
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.headlineMedium,
//                color = MaterialTheme.color.fontPrimary
//            )
        }
    }
}

