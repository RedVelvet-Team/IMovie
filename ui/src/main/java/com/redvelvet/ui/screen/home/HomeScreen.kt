package com.redvelvet.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomTabLayout
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.VerticalSpacer
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeUiState
import com.redvelvet.viewmodel.home.HomeViewModel
import com.skydoves.cloudy.Cloudy

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewHomeScreenVertical() {
    val navController = rememberNavController()
    HomeScreen(navController)
}

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CustomTopAppBar("FlixMovie", hasBackArrow = false)
    }, bottomBar = {
        //TODO @Hassan Ayman
    }, containerColor = Primary
    ) { paddingValues ->
        HomeScreenContent(paddingValues, state)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues, state: HomeUiState) {
    Column(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxWidth()
    ) {
        CustomTabLayout()
        ItemViewPager(listOf(Tata(), Tata(), Tata(), Tata(), Tata()))
        LazyColumn(contentPadding = PaddingValues(vertical = MaterialTheme.spacing.spacing16)) {
            item {
                ItemsSection(label = "Now Playing",
                    images = state.nowPlayingMovies.map { it.movieImage },
                    hasName = true,
                    name = state.nowPlayingMovies.map { it.movieName },
                    hasDateAndCountry = true,
                    date = state.nowPlayingMovies.map { it.movieDate },
                    country = state.nowPlayingMovies.map { it.countryOfMovie })
            }
            item {
                VerticalSpacer(space = 24)
                ItemsSection(label = "Up Coming",
                    images = state.upComingMovies.map { it.movieImage },
                    hasName = true,
                    name = state.upComingMovies.map { it.movieName },
                    hasDateAndCountry = true,
                    date = state.upComingMovies.map { it.movieDate },
                    country = state.upComingMovies.map { it.countryOfMovie })
            }
            item {
                VerticalSpacer(space = 24)
                ItemsSection(label = "Top Rated",
                    images = state.upComingMovies.map { it.movieImage },
                    hasName = true,
                    name = state.upComingMovies.map { it.movieName },
                    hasDateAndCountry = true,
                    date = state.upComingMovies.map { it.movieDate },
                    country = state.upComingMovies.map { it.countryOfMovie })
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemViewPager(data: List<Tata>) {
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        data.size
    }
    HorizontalPager(
        modifier = Modifier.padding(horizontal = 16.dp),
        state = pagerState,
        pageSpacing = 0.dp,
        userScrollEnabled = true,
        reverseLayout = false,
        contentPadding = PaddingValues(0.dp),
        beyondBoundsPageCount = 0,
        pageSize = PageSize.Fill,
        flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
        key = null,
        pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
            Orientation.Horizontal
        )
    ) { page ->
        SlideShowImage(page, data)
    }
}

data class Tata(
    val image: Int = R.drawable.slide,
    val name: String = "John Wick",
    val dateLang: String = "03/24/2023 (us)"
)

@Composable
fun SlideShowImage(page: Int, data: List<Tata>) {
    val onScreen = data[page]
    Card(
        modifier = Modifier.height(210.dp), shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Box(
            modifier = Modifier, contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(onScreen.image),
                contentDescription = "slide show image",
                contentScale = ContentScale.FillBounds
            )
            Cloudy(
                radius = 25,
                modifier = Modifier
                    .shadow(elevation = 12.dp)
                    .alpha(0.8f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                        .background(color = FontAccent),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                        text = onScreen.name,
                        style = Typography.labelMedium,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 4.dp),
                        text = onScreen.dateLang,
                        style = Typography.bodySmall,
                        color = FontAccent
                    )
                }
            }
        }
    }
}






