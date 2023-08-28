package com.redvelvet.ui.screen.game

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.SecondaryCard2
import com.redvelvet.ui.theme.SecondaryCard3
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.game.AnswerUiState
import com.redvelvet.viewmodel.game.Correctness
import com.redvelvet.viewmodel.game.GameUiState
import com.redvelvet.viewmodel.game.GameViewModel
import com.redvelvet.viewmodel.game.QuestionNumberState
import kotlinx.coroutines.launch

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    FlixMovieScaffold(
        isLoading = state.isLoading, error = state.error
    ) {
        if (state.isGameFinished) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.currentScore.toString(),
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineLarge
                )
            }
        } else {
            GameContent(
                state = state, onClick = viewModel::onClickAnswer
            )
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun GameContent(state: GameUiState, onClick: (AnswerUiState) -> Boolean) {
    val questionState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        questionState.animateScrollToItem(state.currentQuestionNumber-1)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DividerRow(number = 24, modifier = Modifier.padding(top = 16.dp))
        LazyRow(
            contentPadding = PaddingValues(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = questionState
        ) {
            items(state.number.size) {
                QuestionNumber(question = state.number[it])
            }
        }
        DividerRow(number = 24)
        Spacer(modifier = Modifier.height(60.dp))
        RepeatableCardStack(
            state = state, onClick = onClick
        )
    }
}


@Composable
fun QuestionNumber(
    question: QuestionNumberState
) {
    val boxBackground by animateColorAsState(
        targetValue = when (question.correctness) {
            Correctness.NOT_ANSWERED -> OnSecondary
            Correctness.CORRECT -> Secondary
            Correctness.WRONG -> Secondary
            Correctness.CURRENT_ANSWERED -> Color(0xFF6C5DD3)
        }, label = ""
    )

    val textColor by animateColorAsState(
        targetValue = when (question.correctness) {
            Correctness.CURRENT_ANSWERED -> MaterialTheme.color.fontPrimary
            Correctness.NOT_ANSWERED -> MaterialTheme.color.fontAccent
            else -> Color.Transparent
        }, label = ""
    )
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(boxBackground)
            .padding(8.dp)
    ) {
        AnimatedVisibility(
            visible = question.correctness == Correctness.CORRECT,
            enter = fadeIn(tween(100))
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0x80FFFFFF))
                    .padding(5.dp),
                painter = painterResource(id = R.drawable.ic_correct),
                contentDescription = "",
                tint = MaterialTheme.color.fontAccent
            )
        }
        AnimatedVisibility(
            visible = question.correctness == Correctness.WRONG,
            enter = fadeIn(tween(100))
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0x80BC4343))
                    .padding(5.dp),
                painter = painterResource(id = R.drawable.ic_wrong),
                contentDescription = "",
                tint = Color(0xFFBC4343)
            )
        }
        AnimatedVisibility(
            visible = question.correctness == Correctness.NOT_ANSWERED || question.correctness == Correctness.CURRENT_ANSWERED,
            enter = fadeIn(tween(100)),
            exit = fadeOut(tween(100))
        ) {
            Text(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Transparent),
                text = question.number.toString(),
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RepeatableCardStack(state: GameUiState, onClick: (AnswerUiState) -> Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp)
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .rotate(4f)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(8.dp))
                .background(SecondaryCard3)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .rotate(-4f)
                .align(Alignment.Center)
                .clip(RoundedCornerShape(8.dp))
                .background(SecondaryCard2)
        )
        Card(
            modifier = Modifier
                .height(120.dp)
                .align(Alignment.Center),
            colors = CardDefaults.cardColors(Secondary),
            shape = RoundedCornerShape(8.dp)
        ) {
            AnimatedContent(
                targetState = state.question, transitionSpec = {
                    fadeIn(tween(1000)) togetherWith fadeOut(tween(100))
                }, label = ""
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
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
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF6C5DD3))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp),
                painter = painterResource(id = R.drawable.ic_point),
                contentDescription = "",
                tint = Color(0xFFF8C33C)
            )
            Text(
                text = state.question.score, style = Typography.bodySmall, color = Color(0xFFE9C03C)
            )
        }
    }

    Spacer(modifier = Modifier.height(100.dp))

    repeat(state.question.answers.size) { index ->
        Answer(
            answer = state.question.answers[index], onClick = onClick, isAnswered = state.isAnswered
        )
    }

}


@Composable
fun Answer(answer: AnswerUiState, onClick: (AnswerUiState) -> Boolean, isAnswered: Boolean) {
    var isSelected by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val backgroundColor by animateColorAsState(
        targetValue = if (answer.text == isSelected) Color.Green else Secondary, label = ""
    )
    val modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = MaterialTheme.spacing.spacing16, vertical = MaterialTheme.spacing.spacing8
        )
        .clip(RoundedCornerShape(16.dp))
        .background(backgroundColor)

    Row(modifier = if (!isAnswered) {
        modifier
            .clickable {
                isSelected = answer.text
                onClick(answer)
            }
            .padding(vertical = MaterialTheme.spacing.spacing16, horizontal = 8.dp)
    } else modifier.padding(vertical = MaterialTheme.spacing.spacing16, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        AnimatedContent(
            targetState = answer, transitionSpec = {
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

@Composable
fun DividerRow(
    number: Int, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(number) {
            Spacer(
                modifier = Modifier
                    .width(12.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(1.dp))
                    .background(Color(0x4DD9D9D9))
            )
        }
    }
}

@Composable
fun QuestionPreview() {

}
