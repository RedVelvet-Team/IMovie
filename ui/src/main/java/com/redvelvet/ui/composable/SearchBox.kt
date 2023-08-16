package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.BackgroundSecondary
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    query: String,
    onChangeQuery: (String) -> Unit,
) {
    SearchBar(
        modifier = modifier.fillMaxWidth(),
        query = query,
        onQueryChange = {onChangeQuery(it)},
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
        colors = SearchBarDefaults.colors(
            containerColor = BackgroundSecondary,
            inputFieldColors = TextFieldDefaults.colors(focusedTextColor = FontSecondary)
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.search_place_holder),
                style = Typography.labelMedium.copy(fontWeight = FontWeight.Normal),
                color = FontAccent,
            )
        },
    ){}
}