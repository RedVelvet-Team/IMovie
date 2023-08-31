package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilxTopAppBar(
    title: String,
    hasBackArrow: Boolean,
    modifier: Modifier = Modifier
) {
    val navController = LocalNavController.current
    Surface(
        modifier = modifier.shadow(
            elevation = MaterialTheme.dimens.dimens2,
            spotColor = MaterialTheme.color.backgroundOnPrimary,
            ambientColor = MaterialTheme.color.backgroundOnPrimary
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
                AnimatedVisibility(hasBackArrow) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.icon_back),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.color.fontSecondary
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.color.backgroundPrimary,
                titleContentColor = MaterialTheme.color.backgroundOnPrimary,
            ),
        )
    }
}

@Composable
@Preview
fun PreviewA() {
    FilxTopAppBar("FlixMovie", true)
}