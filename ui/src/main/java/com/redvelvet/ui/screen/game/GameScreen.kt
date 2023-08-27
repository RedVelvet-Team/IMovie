package com.redvelvet.ui.screen.game

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.SecondaryCard2
import com.redvelvet.ui.theme.SecondaryCard3
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.game.AnswerUiState
import com.redvelvet.viewmodel.game.GameUiState
import com.redvelvet.viewmodel.game.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    FlixMovieScaffold(
        isLoading = state.isLoading,
        error = state.error
    ) {
        if (state.isGameFinished){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Finished", color = Color.White, style = MaterialTheme.typography.headlineLarge)
            }
        }
        GameContent(
            state = state,
            onClick = viewModel::onClickAnswer
        )
    }
}

@Composable
fun GameContent(state: GameUiState, onClick: (AnswerUiState) -> Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        RepeatableCardStack(
            state = state,
            onClick = onClick
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RepeatableCardStack(state: GameUiState, onClick: (AnswerUiState) -> Boolean) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp)
            .height(150.dp)
    ) {
        repeat(3) { index ->
            val cardModifier = Modifier
                .height(120.dp)
                .rotate(
                    when (2 - index) {
                        0 -> 0f
                        1 -> 5f
                        2 -> -5f
                        else -> -5f
                    }
                )
                .alpha(if (2 - index == 0) 1f else .2f)
                .align(Alignment.Center)

            Card(
                modifier = cardModifier,
                colors = CardDefaults.cardColors(
                    containerColor = when (2 - index) {
                        0 -> Secondary
                        1 -> SecondaryCard2
                        3 -> SecondaryCard3
                        else -> Color.Green
                    }
                )
            ) {
                AnimatedContent(
                    targetState = state.question,
                    transitionSpec = {
                        fadeIn(tween(1000)) togetherWith fadeOut(tween(100))
                    }, label = ""
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = it.question,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.color.fontPrimary
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Green)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp),
                painter = painterResource(id = R.drawable.ic_point),
                contentDescription = "",
                tint = Color.White
            )
            Text(
                text = state.score,
                style = Typography.bodySmall,
                color = Color.Black
            )
        }
    }

    Spacer(modifier = Modifier.height(60.dp))

    repeat(state.question.answers.size) {index ->
        Answer(answer = state.question.answers[index], onClick = onClick, isAnswered = state.isAnswered)
    }

}


@Composable
fun Answer(answer: AnswerUiState, onClick: (AnswerUiState) -> Boolean, isAnswered: Boolean) {
    var isSelected by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val backgroundColor by animateColorAsState(
        targetValue = if (answer.text == isSelected) Color.Green else Secondary,
        label = "")
    val modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = MaterialTheme.spacing.spacing16,
            vertical = MaterialTheme.spacing.spacing4
        )
        .clip(RoundedCornerShape(16.dp))
        .background(backgroundColor)

    Row(
        modifier = if (!isAnswered){
            modifier
                .clickable {
                    isSelected = answer.text
                    val isCorrect = onClick(answer)
                    Toast
                        .makeText(
                            context,
                            if (isCorrect) "Correct" else "false",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
                .padding(vertical = MaterialTheme.spacing.spacing16)
        } else modifier.padding(vertical = MaterialTheme.spacing.spacing16) ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedContent(
            targetState = answer,
            transitionSpec = {
                fadeIn(tween(1000)) togetherWith fadeOut(tween(100))
            }, label = ""
        ) {
            Text(
                text = it.text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.color.fontPrimary
            )
        }
    }
}
