package com.redvelvet.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.composable.SectionHeader
import com.redvelvet.ui.composable.VerticalSpacer
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Typography

/*@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=landscape,width=360dp,height=800dp"
)
@Composable
fun PreviewHomeScreenHorizontal(){
    HomeScreenContent(paddingValues = PaddingValues(16.dp))
}*/

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewHomeScreenVertical(){
    HomeScreen()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomTopAppBar("FlixMovie",hasBackArrow = false)
        },
        bottomBar = {},
        containerColor = Primary
    ) { paddingValues ->
        HomeScreenContent(paddingValues)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues) {
    Column(modifier = Modifier
        .padding(top = 64.dp)
        .padding(horizontal = 16.dp)) {
        CustomTabLayout()
        VerticalSpacer(space = 16)
        SectionHeader("Popular Movies")
        ItemBasicCard()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemBasicCard() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.baseline_do_disturb_alt_24),
            contentDescription = stringResource(R.string.poster),
            modifier = Modifier
                .width(104.dp)
                .height(130.dp)
                .background(Color.White)
        )

    }
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(104.dp)
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

    }
}


@Composable
fun CustomTabLayout() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Movies","TV Shows")
    Column(modifier = Modifier
        .fillMaxWidth()) {
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
                        }
                    )
                    if (state == index) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.6f)
                                .height(4.dp)
                                .align(androidx.compose.ui.Alignment.BottomCenter)
                                .background(Purple100, RoundedCornerShape(50))
                        )
                    }
                }
            }
        }
    }
}