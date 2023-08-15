package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color

@Composable
fun SeeMoreList(
    onClickSeeAll: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth().then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .clickable { onClickSeeAll },
            text = stringResource(R.string.see_all),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.color.fontAccent,
            textAlign = TextAlign.Center
        )
    }
}