package com.redvelvet.ui.screen.game

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryOutlinedButton
import com.redvelvet.ui.screen.game.composable.AnswerCard
import com.redvelvet.ui.screen.game.composable.DividerRow
import com.redvelvet.ui.screen.game.composable.QuestionCard
import com.redvelvet.ui.screen.game.composable.QuestionNumberStatus
import com.redvelvet.ui.screen.game.composable.WinnerDialog
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.game.AnswerUiState
import com.redvelvet.viewmodel.game.GameUiState
import com.redvelvet.viewmodel.game.QuestionsViewModel
import kotlinx.coroutines.launch

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    FlixMovieScaffold(
        isLoading = state.isLoading, error = state.error
    ) {
        AnimatedVisibility(
            visible = state.isGameFinished, enter = fadeIn(tween(1000))
        ) { WinnerDialog(
            onClickHome = {},
            onClickPlayAgain = {},
            score = state.currentScore
        ) }

        QuestionsContent(
            state = state, onClickAnswer = viewModel::onClickAnswer
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun QuestionsContent(state: GameUiState, onClickAnswer: (AnswerUiState) -> Unit) {
    val questionStatusSliderState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        questionStatusSliderState.animateScrollToItem(state.currentQuestionNumber - 1)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DividerRow(number = 24, modifier = Modifier.padding(top = 16.dp))
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = questionStatusSliderState
        ) {
            items(state.number.size) {
                QuestionNumberStatus(question = state.number[it])
            }
        }
        DividerRow(number = 24)
        Spacer(modifier = Modifier.height(60.dp))
        QuestionCard(question = state.question.text, score = state.question.score)
        Spacer(modifier = Modifier.height(100.dp))
        repeat(state.question.answers.size) { index ->
            AnswerCard(
                answer = state.question.answers[index],
                onClick = onClickAnswer,
                isAnswered = state.isAnswered
            )
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicDialog(
    submitText: String,
    onSubmitClick: () -> Unit,
    onClickCancel: () -> Unit,
    modifier: Modifier = Modifier,
    cancelText: String = "Cancel",
    content: @Composable (() -> Unit),
) {

    AlertDialog(onDismissRequest = onClickCancel) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(MaterialTheme.spacing.spacing16))
                .background(MaterialTheme.color.backgroundPrimary)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = 34.dp, horizontal = MaterialTheme.spacing.spacing16
                    )
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    PrimaryOutlinedButton(
                        modifier = modifier
                            .weight(1f)
                            .padding(end = MaterialTheme.spacing.spacing4),
                        onClick = onClickCancel,
                        text = cancelText,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8),
                    )
                    PrimaryButton(
                        modifier = modifier
                            .padding(start = MaterialTheme.spacing.spacing4)
                            .weight(1f),
                        onClick = onSubmitClick,
                        text = submitText,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8),
                    )
                }
            }
        }
    }
}
