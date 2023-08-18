package com.redvelvet.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.SeeAllMovie

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeViewPager(
    state: PagerState,
    label: String = "Popular",
    items: List<ItemUiState>,
    onClickSeeAll: (SeeAllMovie) -> Unit = {},
) {
    Column {
        SectionHeader(label = label, onClickSeeAll =onClickSeeAll, seeAllMovie = SeeAllMovie.POPULAR)
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
                        contentScale = ContentScale.Crop,
                        painter = rememberAsyncImagePainter(
                            model = items[it].image, placeholder = painterResource(
                                id = R.drawable.wallpaper
                            )
                        ),
                        contentDescription = "",
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f)
                            .align(Alignment.BottomCenter)
                            .alpha(2f)
                            .blur(500.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.blur),
                            contentDescription = ""
                        )
                    }
                    Text(
                        text = items[it].name,
                        textAlign = TextAlign.Start,
                        style = Typography.titleMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .align(Alignment.BottomStart)
                            .padding(bottom = 26.dp)
                    )
                    Text(
                        text = "${items[it].date} ${items[it].country}",
                        textAlign = TextAlign.Start,
                        style = Typography.titleSmall,
                        color = Color.White,
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