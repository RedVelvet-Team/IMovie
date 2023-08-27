package com.redvelvet.ui.screen.fun_activites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController

@Composable
fun FunScreen() {
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent)

    FunContent()
}

@Composable
fun FunContent() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn() {

        }

        LazyColumn(
           // modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            items(12) { position ->
                FunItem( onClickItem = {  })
            }
        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFunScreen() {
    FunScreen()
}