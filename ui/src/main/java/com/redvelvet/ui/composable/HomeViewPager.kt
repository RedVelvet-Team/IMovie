package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.MediaType
import com.redvelvet.viewmodel.utils.SeeAllMovie
import com.redvelvet.viewmodel.utils.SeeAllTvShows

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeViewPager(
    label: String = "Popular",
    items: List<ItemUiState>,
    onClickSeeAllMovie: (SeeAllMovie) -> Unit = {},
    onClickItem: (String) -> Unit,
    onClickSeeAllTv: (SeeAllTvShows) -> Unit,
    type: MediaType,
) {
    Column {
        SectionHeader(
            label = label,
            onClickSeeAllMovie = onClickSeeAllMovie,
            seeAllMovie = SeeAllMovie.POPULAR,
            onClickSeeAllTv = onClickSeeAllTv,
            seeAllTv = SeeAllTvShows.POPULAR,
            type = type,
        )
        LazyRow {
            items(items) { item ->
                Card(
                    onClick = { onClickItem(item.id) },
                    shape = RoundedCornerShape(CornerSize(16.dp)),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(330.dp)
                        .height(210.dp)
                        .padding(top = 8.dp)
                ) {
                    CardContent(item)
                }
            }

        }
    }
}

@Composable
fun CardContent(item: ItemUiState) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                model = item.image,
                placeholder = painterResource(id = R.drawable.wallpaper)
            ),
            contentDescription = "",
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.33f)
                .align(Alignment.BottomCenter)
                .alpha(2f)
                .blur(500.dp)
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .3f to Color.White,
                        .8f to Color.White,
                        1F to Color.White
                    )
                )
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    model = item.image,
                    placeholder = painterResource(id = R.drawable.wallpaper)
                ),
                contentDescription = "",
            )
        }
        Text(
            text = item.name,
            textAlign = TextAlign.Start,
            style = Typography.titleMedium,
            color = MaterialTheme.color.fontPrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(start = 12.dp)
                .align(Alignment.BottomStart)
                .padding(bottom = 26.dp)
        )
        Text(
            text = "${item.date} ${item.country}",
            textAlign = TextAlign.Start,
            style = Typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.color.fontPrimary,
            modifier = Modifier
                .padding(start = 12.dp)
                .align(Alignment.BottomStart)
                .padding(bottom = 4.dp)
        )
    }
}