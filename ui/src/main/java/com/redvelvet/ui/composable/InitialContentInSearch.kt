package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.spacing

@Preview(showSystemUi = true)
@Composable
fun InitialContentInSearch(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.vector_serach),
            contentDescription = " No Search Results "
        )
        StatusText(
            statusTitle = "Search in Movie",
            statusDescription = "Search for your favorite movies and\nTV shows that you love.",
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32)
        )
    }
}