package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontPrimary
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
        Row(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.spacing12)
                .padding(top = MaterialTheme.spacing.spacing12)
        ) {
            Text(
                text = "Written by ".plus(name).plus(" "),
                style = Typography.headlineSmall,
                color = FontPrimary,
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.icon_star_filled),
                contentDescription = stringResource(R.string.icon_rating)
            )
            Text(
                text = rating.toString(),
                style = Typography.titleSmall,
                color = FontPrimary,
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing4)
            )
        }
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