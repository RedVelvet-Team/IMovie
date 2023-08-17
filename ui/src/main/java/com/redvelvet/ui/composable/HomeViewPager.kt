package com.redvelvet.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeViewPager(state: PagerState, label: String = "Popular") {
    Column {
        SectionHeader(label = label)
        HorizontalPager(state = state) {
            Card(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(CornerSize(16.dp)),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(210.dp)
                    .padding(top = 8.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        contentScale = ContentScale.FillBounds,
                        painter = painterResource(id = R.drawable.wallpaper),
                        contentDescription = ""
                    )
                    Text(
                        text = "The Movie Show",
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .align(Alignment.BottomStart)
                            .padding(bottom = 26.dp)
                    )
                    Text(
                        text = "03/24/2023 (US)",
                        textAlign = TextAlign.Start,
                        style = Typography.titleSmall,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .align(Alignment.BottomStart)
                            .padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestHomeViewPager() {
    HomeViewPager(rememberPagerState {
        1
    })
}