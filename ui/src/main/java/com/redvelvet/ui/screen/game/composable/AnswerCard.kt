package com.redvelvet.ui.screen.game.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.game.AnswerUiState

@Composable
fun AnswerCard(
    answer: AnswerUiState,
    onClick: (AnswerUiState) -> Unit,
    isAnswered: Boolean
) {
    var isSelected by remember {
        mutableStateOf("")
    }

    val backgroundColor by animateColorAsState(
        targetValue = if (answer.text == isSelected) Color(0xFF3E8B32) else Secondary, label = ""
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
    } else{ modifier.padding(vertical = MaterialTheme.spacing.spacing16, horizontal = 8.dp)},
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