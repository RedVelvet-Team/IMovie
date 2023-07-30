package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
) {
    SearchBar(
        modifier = modifier.fillMaxWidth(),
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = stringResource(R.string.search_icon),
                tint = FontAccent
            )
        },
        shape = RoundedCornerShape(MaterialTheme.dimens.dimens16),
        colors = SearchBarDefaults.colors(containerColor = Secondary),
        placeholder ={
            Text(
            text = stringResource(R.string.search_place_holder),
            style = Typography.bodyMedium,
            color = FontAccent,
        )
        }
    ){}
}