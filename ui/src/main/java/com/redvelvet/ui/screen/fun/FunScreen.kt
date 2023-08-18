package com.redvelvet.ui.screen.`fun`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FunScreen() {
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