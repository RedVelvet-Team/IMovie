package com.redvelvet.ui.screen.game.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.game.Correctness
import com.redvelvet.viewmodel.game.QuestionNumberState

@Composable
fun QuestionNumberStatus(
    question: QuestionNumberState
) {
    val boxBackground by animateColorAsState(
        targetValue = when (question.correctness) {
            Correctness.NOT_ANSWERED -> OnSecondary
            Correctness.CORRECT -> Secondary
            Correctness.WRONG -> Secondary
            Correctness.CURRENT_ANSWERED -> Color(0xFF6C5DD3)
        }, label = "")

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