package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.theme.FontAccent
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemReview(
    name: String,
    rating: Double,
    date: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.color.backgroundSecondary),
        shape = RoundedCornerShape(MaterialTheme.radius.radius16),
        modifier = modifier
    ) {
        NameWithRatingRow(
            name = "Written by ".plus(name),
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
            style = Typography.displaySmall
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
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PreviewItemReview() {
    ItemReview(
        name = "Haidy",
        rating = 8.9,
        date = "May 31,2023",
        content = "Halle Bailey served a very good performance with a lot of charisma and passion, she also has an impressive voice. In some parts people were clapping from excitement and I shed a tear since I saw her performing her first song.",
        modifier = Modifier
            .width(MaterialTheme.dimens.dimens270)
            .height(MaterialTheme.dimens.dimens143)
    )
}