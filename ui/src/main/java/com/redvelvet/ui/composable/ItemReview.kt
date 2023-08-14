package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

/// implemented by haidy
@Composable
fun ItemReview(
    id: String,
    name: String,
    rating: Double,
    date: String,
    content: String,
    modifier: Modifier = Modifier,
    onClick: (id: String) -> Unit = {}

) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Secondary),
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        modifier = modifier.clickable { onClick(id) }
    ) {
        NameWithRatingRow(
            name = "Written by ".plus(name).plus(" "),
            rating = rating,
            textNameStyle = Typography.titleSmall,
            rowModifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.spacing12)
                .padding(top = MaterialTheme.spacing.spacing12)
        )
        Text(
            text = date,
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.spacing12,
                top = MaterialTheme.spacing.spacing4,
                bottom = MaterialTheme.spacing.spacing8
            ),
            color = FontSecondary,
            style = Typography.displaySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = content,
            modifier = Modifier.padding(
                start = MaterialTheme.spacing.spacing12,
                end = MaterialTheme.spacing.spacing12,
                bottom = MaterialTheme.spacing.spacing12
            ),
            color = FontAccent,
            style = Typography.displaySmall,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}