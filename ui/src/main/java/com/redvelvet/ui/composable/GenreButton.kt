package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun GenreButton(genre: String) {
    Button(
        modifier = Modifier
            .height(24.dp)
            .padding(end = MaterialTheme.spacing.spacing4),
        onClick = {},
        colors = ButtonDefaults.buttonColors(OnSecondary),
        shape = RoundedCornerShape(MaterialTheme.radius.radius8)
    ) {
        Text(
            text = genre,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    horizontal = MaterialTheme.spacing.spacing8,
                    vertical = MaterialTheme.spacing.spacing4
                ),
            style = Typography.titleSmall.copy(color = FontSecondary)
        )
    }
}