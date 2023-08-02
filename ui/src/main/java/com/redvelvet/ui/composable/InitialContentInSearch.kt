package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
        StatusImage(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.vector_serach),
            contentDescription = stringResource(R.string.no_search_results)
        )
        Spacer( modifier = modifier.height(MaterialTheme.spacing.spacing32))
        StatusText(
            statusTitle = stringResource(R.string.search_in_movie),
            statusDescription = stringResource(R.string.search_for_your_favorite_movies)
        )
    }
}