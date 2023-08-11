package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.search.CategoryUiState
import com.redvelvet.viewmodel.utils.SearchMedia

@Composable
fun CategoriesChips(
    onChangeCategory: (SearchMedia) -> Unit,
    selectedType: SearchMedia,
    categories: List<CategoryUiState>,
    modifier: Modifier = Modifier,
    title: String
) {
    Text(
        modifier = modifier.padding(
            top = MaterialTheme.spacing.spacing16,
            start = MaterialTheme.spacing.spacing16
        ),
        text = title,
        style = Typography.displayMedium,
        color = FontSecondary
    )
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.spacing16,
            vertical = MaterialTheme.spacing.spacing8,
        ),
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
    ) {
        items(categories.size) {
            val category = categories[it]
            CategoryChip(
                onChangeCategory,
                text = category.text,
                type = category.type,
                selectedType = selectedType
            )
        }
    }
}