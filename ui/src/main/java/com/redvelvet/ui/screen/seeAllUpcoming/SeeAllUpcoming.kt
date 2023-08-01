package com.redvelvet.ui.screen.seeAllUpcoming

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.spacing

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeeAllUpcomingListScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { CustomTopAppBar(stringResource(R.string.upcoming), hasBackArrow = true) },
        containerColor = Primary
    ) {
        SeeAllUpcomingListContent()
    }
}

@Composable
private fun SeeAllUpcomingListContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(top = MaterialTheme.spacing.spacing64)
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16, vertical = MaterialTheme.spacing.spacing24),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing16, Alignment.CenterVertically)
        ) {
            items(20) {
                ItemBasicCard(
                    image ="",
                    hasName = true,
                    name = "Al amal",
                    hasDateAndCountry = true,
                    date = "23/10/2003",
                    country = "(Us)"
                )
            }
        }
    }
}