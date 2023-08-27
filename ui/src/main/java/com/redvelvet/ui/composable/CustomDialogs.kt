package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing

// region DialogWithIcon
@Composable
fun DialogWithIcon(
    modifier: Modifier = Modifier,
    showDialogState: Boolean,
    submitText: String,
    onSubmitClick: () -> Unit
) {
    BasicDialog(
        modifier = modifier,
        showDialogState = showDialogState,
        submitText = submitText,
        onSubmitClick = onSubmitClick,
        content = {
            Image(
                painter = painterResource(R.drawable.vector_logo),
                contentDescription = "Flix Movie Logo",
                modifier = Modifier
                    .size(66.dp)
                    .padding(bottom = MaterialTheme.spacing.spacing16),
            )
            Text(
                modifier = modifier.padding(bottom = MaterialTheme.spacing.spacing32),
                text = "Hello! \n" +
                        "Please log in to continue \n" +
                        "and add content to your saved list",
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.color.fontPrimary
            )
        }
    )
}
//endregion

// region DialogWithLink
@Composable
fun DialogWithLink(
    modifier: Modifier = Modifier,
    headText: String,
    bodyText: String,
    placeHolderText: String,
    submitText: String,
    isError: Boolean,
    showDialogState: Boolean,
    link: String,
    onTextChange: (String) -> Unit,
    onSubmitClick: () -> Unit,
) {
    var link by remember { mutableStateOf(link) }
    BasicDialog(
        modifier = modifier,
        showDialogState = showDialogState,
        submitText = submitText,
        onSubmitClick = onSubmitClick,
        content = {
            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing8),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                text = headText,
                color = MaterialTheme.color.fontPrimary,
            )
            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing16),
                style = MaterialTheme.typography.labelMedium,
                text = bodyText,
                textAlign = TextAlign.Center,
                color = MaterialTheme.color.fontSecondary,
            )
            PrimaryTextField(
                modifier = modifier.padding(bottom = MaterialTheme.spacing.spacing8),
                placeHolderText = placeHolderText,
                errorMessage = "inCorrect Link please re write again, hello do it just keep going",
                value = link,
                isError = isError,
                onTextChange = {
                    link = it
                    onTextChange(it)
                }
            )
        }
    )
}
//endregion

// region RatingDialog
@Composable
fun RatingDialog(
    movieName: String,
    showDialogState: Boolean,
    ratingState: Float,
    onSubmitClick: () -> Unit,
    onRatingChanged: (rating: Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    var rating: Float by remember { mutableFloatStateOf(ratingState) }
    BasicDialog(
        modifier = modifier,
        showDialogState = showDialogState,
        submitText = "Rate",
        onSubmitClick = onSubmitClick,
        content = {
            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing24),
                textAlign = TextAlign.Center,
                color = MaterialTheme.color.fontPrimary,
                style = MaterialTheme.typography.titleMedium,
                text = "How would you rate $movieName ?"
            )
            RatingBar(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing32),
                value = rating,
                painterEmpty = painterResource(id = R.drawable.rate_action_star),
                painterFilled = painterResource(id = R.drawable.rated_star),
                onValueChange = { rating = it },
                onRatingChanged = onRatingChanged
            )
        }
    )
}
//endregion


@Preview
@Composable
fun DialogWithIconPreview() {
    DialogWithIcon(onSubmitClick = {}, submitText = "Login", showDialogState = true)
}
@Preview
@Composable
fun DialogWithLinkPreview() {
    DialogWithLink(
        headText = "Create a room",
        bodyText = "Try it by ur self",
        placeHolderText = "do what ever u need ",
        showDialogState = true,
        submitText = "Create",
        isError = false,
        onSubmitClick = {},
        onTextChange = {},
        link = "")
}
@Preview
@Composable
fun RateDialogPreview() {
    RatingDialog(
        onSubmitClick = {},
        showDialogState = true,
        ratingState = 4f,
        movieName = "SuperWoman njnerj ns nsnfn s nkndfkjn  lkslk ",
        onRatingChanged = {})
}