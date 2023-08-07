package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeViewModel

@Composable
fun FilxTabLayout(viewModel: HomeViewModel = HomeViewModel()) {
    val state by viewModel.state.collectAsState()
    FilxTabLayoutContent(state.selectedTabIndex, state.tabLayoutTitles, viewModel::onClickTab)
}

@Composable
fun FilxTabLayoutContent(
    selectedTabIndex: Int,
    titles: List<String>,
    onClickTab: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.color.backgroundPrimary,
            indicator = {
            },
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Box {
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { onClickTab(index) },
                        text = {
                            Text(
                                text = title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.White,
                                style = Typography.headlineSmall
                            )
                        })
                    if (selectedTabIndex == index) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.6f)
                                .height(MaterialTheme.dimens.dimens4)
                                .align(Alignment.BottomCenter)
                                .background(MaterialTheme.color.brand100, RoundedCornerShape(50))
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewTabLayout() {
    FilxTabLayout()
}