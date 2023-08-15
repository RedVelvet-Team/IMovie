package com.redvelvet.ui.composable

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.Montserrat

@Composable
fun LongExpandedText(overview: String) {
    var textExpanded by remember { mutableStateOf(false) }
    val shortText = overview.take(130)
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = Montserrat,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = FontPrimary,
            )
        ) {
            append(if (textExpanded) overview else shortText)
            if (!textExpanded) append("...") else append(" ")
            withStyle(
                style = SpanStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = FontPrimary,
                )
            ) {
                append(if (textExpanded) "Less" else "More")
                // Add an annotation that stores the "More" or "Less" range
                addStringAnnotation(
                    tag = "Clickable",
                    annotation = if (textExpanded) "Less" else "More",
                    start = length - 4,
                    end = length
                )
            }
        }
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "Clickable", start = offset, end = offset)
                .firstOrNull()?.let {
                    textExpanded = !textExpanded
                }
        },
        style = MaterialTheme.typography.labelMedium
    )
}
