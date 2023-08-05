package com.redvelvet.ui.composable

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.OnPrimary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    hasBackArrow: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.shadow(
            elevation = MaterialTheme.dimens.dimens2,
            spotColor = OnPrimary,
            ambientColor = OnPrimary
        )
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = Typography.headlineLarge
                )
            },
            navigationIcon = {
                when (hasBackArrow) {
                    true -> {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.icon_back),
                                contentDescription = stringResource(R.string.localized_description),
                                tint = OnPrimary
                            )
                        }
                    }

                    false -> {}
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Primary,
                titleContentColor = OnPrimary,
            )
        )
    }
}