package com.redvelvet.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomTabLayout
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.VerticalSpacer
import com.redvelvet.ui.theme.Primary

@Preview(
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
fun PreviewHomeScreenVertical() {
    HomeScreen()
}


@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CustomTopAppBar("FlixMovie", hasBackArrow = false)
    }, bottomBar = {
                   //TODO @Hassan Ayman
    },
        containerColor = Primary
    ) { paddingValues ->
        HomeScreenContent(paddingValues)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxWidth()
    ) {
        CustomTabLayout()
        VerticalSpacer(space = 16)

        LazyColumn{
            item {
                VerticalSpacer(space = 24)
                ItemsSection(
                    label = "Popular Movies",
                    image = R.drawable.baseline_do_disturb_alt_24,
                    hasName = true,
                    name = "Guardians of the Galaxy vol. 3",
                    hasDateAndCountry = true,
                    date = "22/05/2023",
                    country = "US"
                )
            }
            item{
                VerticalSpacer(space = 24)
                ItemsSection(
                    label = "Up Coming",
                    image = R.drawable.baseline_do_disturb_alt_24,
                    hasName = true,
                    name = "Guardians of the Galaxy vol. 3",
                    hasDateAndCountry = true,
                    date = "22/05/2023",
                    country = "US"
                )
            }
            item{
                VerticalSpacer(space = 24)
                ItemsSection(
                    label = "Top Rated",
                    image = R.drawable.baseline_do_disturb_alt_24,
                    hasName = true,
                    name = "Guardians of the Galaxy vol. 3",
                    hasDateAndCountry = true,
                    date = "22/05/2023",
                    country = "US"
                )
            }
        }

    }
}






