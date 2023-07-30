package com.redvelvet.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Primary

/*@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=landscape,width=360dp,height=800dp"
)
@Composable
fun PreviewHomeScreenHorizontal(){
    HomeScreenContent(paddingValues = PaddingValues(16.dp))
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewHomeScreenVertical(){
    HomeScreenContent(paddingValues = PaddingValues(16.dp))
}*/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
                 TopAppBar(title = { Text(text = "FilxMovie") })
        },
        bottomBar = {},
        containerColor = Primary
    ) {paddingValues ->
        HomeScreenContent(paddingValues)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues) {
    
}


@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun Preview(){
    Section("Top Rated", emptyList())
}

@Composable
fun Section(sectionName: String,list:List<String>) {
    Column {
        Row (horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = sectionName)
            Text(text = "see all")
        }
        LazyRow{

        }
    }
}
