package com.redvelvet.ui.screen.game.composable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.SecondaryCard2
import com.redvelvet.ui.theme.SecondaryCard3
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color

@Composable
fun QuestionCard(question: String, score: String) {
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
                targetState = question, transitionSpec = {
                    fadeIn(tween(1000)) togetherWith fadeOut(tween(100))
                }, label = ""
            ) { question ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = question,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
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
                text = score, style = Typography.bodySmall, color = Color(0xFFE9C03C)
            )
        }
    }


}