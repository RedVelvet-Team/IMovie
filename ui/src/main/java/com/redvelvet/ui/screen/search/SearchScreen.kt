package com.redvelvet.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.InitialContentInSearch
import com.redvelvet.ui.composable.SearchBox
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.search.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    SearchContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
private fun SearchContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
            .padding(MaterialTheme.dimens.dimens16)
    ) {
        SearchBox()
        InitialContentInSearch()
    }
}


