package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.BackgroundSecondary
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens

@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    query: String,
    onChangeQuery: (String) -> Unit,
    onClickClear: () -> Unit
) {
    OutlinedTextField(
        value = query,
        onValueChange = { onChangeQuery(it) },
        modifier = modifier.fillMaxWidth(),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.icon_search),
                contentDescription = stringResource(R.string.search_icon),
                tint = FontAccent
            )
        },
        trailingIcon ={
            IconButton(onClick = onClickClear){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = FontAccent
                )
            }
        },
        shape = RoundedCornerShape(MaterialTheme.dimens.dimens16),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = FontSecondary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedLabelColor = FontSecondary,
            unfocusedContainerColor = BackgroundSecondary,
            focusedContainerColor = BackgroundSecondary
        ),
        textStyle = Typography.labelMedium.copy(fontWeight = FontWeight.Normal, color = FontSecondary),
        placeholder = {
            Text(
                text = stringResource(R.string.search_place_holder),
                style = Typography.labelMedium.copy(fontWeight = FontWeight.Normal),
                color = FontAccent
            )
        },
        singleLine = true
    )
}