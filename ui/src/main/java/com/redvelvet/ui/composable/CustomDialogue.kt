package com.redvelvet.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun CustomDialogue(
//    inputField: String,
//    onClickCancel: () -> Unit,
//    onClickCreate: () -> Unit,
    hasLinkField: Boolean = true

) {
    Box(
        modifier = Modifier
            .width(260.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(MaterialTheme.spacing.spacing16))
            .background(MaterialTheme.color.backgroundPrimary)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    horizontal = MaterialTheme.spacing.spacing16,
                    vertical = MaterialTheme.spacing.spacing24
                )
        ) {
            LinkBox()
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(all = MaterialTheme.spacing.spacing16)
        ) {
            PrimaryOutlinedButton(
                modifier = Modifier
                    .size(width = 110.dp, height = 48.dp),
                onClick = { },
//                enabled = !state.isLoading,
                border = BorderStroke(
                    width = MaterialTheme.dimens.dimens1,
                    color = MaterialTheme.color.brand60
                ),
                text = "Cancel",
                textColor = MaterialTheme.color.brand100,
            )
            SpacerHorizontal(width = MaterialTheme.spacing.spacing8)
            PrimaryButton(
                modifier = Modifier
                    .size(width = 110.dp, height = 48.dp),
                onClick = { },
                buttonColor = MaterialTheme.color.brand60,
                text = "Share Room",
                textColor = MaterialTheme.color.fontSecondary
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewScreen() {
    CustomDialogue()
}

@Composable
fun LinkBox() {
    Text(
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.spacing32
        ),
        style = MaterialTheme.typography.bodyMedium,
        text = "Create cinema room",
        color = MaterialTheme.color.fontPrimary,
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing8)
    Text(
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.spacing4
        ),
        style = MaterialTheme.typography.labelMedium,
        text = "You can share the room with friends  ",
        color = MaterialTheme.color.fontPrimary,
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing16)
    Row(
        modifier = Modifier
            .size(width = 228.dp, height = 40.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.color.backgroundSecondary)

    ) {
        SpacerVertical(height = MaterialTheme.spacing.spacing16)
        Text(
            modifier = Modifier.padding(
                all = MaterialTheme.spacing.spacing12
            ),
            textAlign = TextAlign.Center,
            text = "Movie Link",
            color = MaterialTheme.color.fontSecondary
        )
    }
}
