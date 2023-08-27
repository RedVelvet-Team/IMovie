package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun BasicDialog(
    showDialogState: Boolean,
    submitText: String,
    onSubmitClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit),
) {
    var showDialog by remember { mutableStateOf(showDialogState) }
    Dialog(onDismissRequest = { showDialog = false }) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(MaterialTheme.spacing.spacing16))
                .background(MaterialTheme.color.backgroundPrimary)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = MaterialTheme.spacing.spacing34,
                        horizontal = MaterialTheme.spacing.spacing16
                    )
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                content()
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Bottom
                ) {
                    PrimaryOutlinedButton(
                        modifier = modifier
                            .weight(1f)
                            .padding(end = MaterialTheme.spacing.spacing4),
                        onClick = { showDialog = false },
                        text = "Cancel",
                        textStyle = MaterialTheme.typography.bodyMedium,
                        buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8),
                        buttonHeight = MaterialTheme.dimens.dimens36
                    )
                    PrimaryButton(
                        modifier = modifier
                            .padding(start = MaterialTheme.spacing.spacing4)
                            .weight(1f),
                        onClick = onSubmitClick,
                        text = submitText,
                        textStyle = MaterialTheme.typography.bodyMedium,
                        buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8),
                        buttonHeight = MaterialTheme.dimens.dimens36
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BasicDialogPreview() {
    BasicDialog(true, "Done", {}, content = {}, modifier = Modifier)
}

