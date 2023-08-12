package com.redvelvet.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.redvelvet.ui.theme.BackgroundSecondary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.utils.SearchMedia

@Composable
fun CategoryChip(
    onClickChip: (SearchMedia) -> Unit,
    text: String,
    type: SearchMedia,
    selectedType: SearchMedia,
    modifier: Modifier = Modifier
) {
    val color by animateColorAsState(
        targetValue = if (type == selectedType) Purple100 else BackgroundSecondary,
        label = ""
    )
    Text(
        modifier = modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(color = color)
            .clickable { onClickChip(type) }
            .padding(
                vertical = MaterialTheme.spacing.spacing8,
                horizontal = MaterialTheme.spacing.spacing16
            ),
        text = text,
        style = Typography.headlineSmall.copy(fontWeight = FontWeight.Normal),
        color = FontSecondary,
    )
}