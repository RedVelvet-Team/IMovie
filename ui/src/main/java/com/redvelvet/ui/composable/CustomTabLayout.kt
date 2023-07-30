package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Typography


@Composable
fun CustomTabLayout() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Movies", "TV Shows")
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        TabRow(
            selectedTabIndex = state,
            contentColor = Color.White,
            containerColor = Primary,
        ) {
            titles.forEachIndexed { index, title ->
                Box {
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = {
                            Text(
                                text = title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.White,
                                style = Typography.headlineSmall
                            )
                        })
                    if (state == index) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.6f)
                                .height(4.dp)
                                .align(Alignment.BottomCenter)
                                .background(Purple100, RoundedCornerShape(50))
                        )
                    }
                }
            }
        }
    }
}