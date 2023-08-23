package com.redvelvet.ui.composable

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import org.w3c.dom.Text

@Composable
fun CustomDialogue(
    hasDefaultBox: Boolean = false,
    hasLinkBox: Boolean = false,
    hasRateBox: Boolean = false,
    hasCreateNewListBox: Boolean = true

) {
    Box(
        modifier = Modifier
            .size(260.dp)
            .clip(RoundedCornerShape(MaterialTheme.spacing.spacing16))
            .background(MaterialTheme.color.backgroundPrimary)
    ) {
        AnimatedVisibility(visible = hasLinkBox) {
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
        }
        AnimatedVisibility(visible = hasRateBox) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        horizontal = MaterialTheme.spacing.spacing16,
                        vertical = MaterialTheme.spacing.spacing24
                    )
            ) {
                RateBox()
            }
        }
        AnimatedVisibility(visible = hasDefaultBox) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        horizontal = MaterialTheme.spacing.spacing16,
                        vertical = MaterialTheme.spacing.spacing24
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                DefaultBox()
            }
        }
        AnimatedVisibility(visible = hasCreateNewListBox) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(
                        horizontal = MaterialTheme.spacing.spacing16,
                        vertical = MaterialTheme.spacing.spacing24
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CreateNewListBox()
            }
        }

    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewScreen() {
    CustomDialogue()
}

@Composable
fun CreateNewListBox() {
    LinkBox(headText = "Create a new list",
        secondaryText = "Create a new list and keep track of \n" +
                "your movies that you want to\n" +
                "access easily",
        boxTitle = "Title",
        buttonText = "Create"
    )

}


@Composable
fun DefaultBox() {
    Image(
        painter = painterResource(R.drawable.vector_logo),
        contentDescription = null,
        modifier = Modifier.size(66.dp),
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing16)
    Text(
        text = "Hello! \n" +
                "Please log in to continue \n" +
                "and add content to your saved list",
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center,
        color = MaterialTheme.color.fontPrimary
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing32)
    Row {
        PrimaryOutlinedButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1,
                color = MaterialTheme.color.brand60
            ),
            text = "Cancel",
            textColor = MaterialTheme.color.brand100,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing8)
        PrimaryButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            buttonColor = MaterialTheme.color.brand60,
            text = "Login",
            textColor = MaterialTheme.color.fontSecondary,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
    }
}


@Composable
fun LinkBox(
    headText: String = "Create cinema room",
    secondaryText: String = "You can share the room with friends  ",
    boxTitle:String="Movie Link",
    buttonText:String="Share Room"
) {
    Text(
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.spacing32
        ),
        style = MaterialTheme.typography.bodyMedium,
        text = headText,
        color = MaterialTheme.color.fontPrimary,
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing8)
    Text(
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.spacing4
        ),
        style = MaterialTheme.typography.labelMedium,
        text = secondaryText,
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
            text = boxTitle,
            color = MaterialTheme.color.fontSecondary
        )
    }
    SpacerVertical(height = MaterialTheme.spacing.spacing32)
    Row {
        PrimaryOutlinedButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1,
                color = MaterialTheme.color.brand60
            ),
            text = "Cancel",
            textColor = MaterialTheme.color.brand100,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing8)
        PrimaryButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            buttonColor = MaterialTheme.color.brand60,
            text = buttonText,
            textColor = MaterialTheme.color.fontSecondary,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
    }
}

@Composable
fun RateBox() {
    var rating: Float by remember { mutableStateOf(3.2f) }
    val movieName: String = "Example"
    Text(
        modifier = Modifier.padding(
            all = MaterialTheme.spacing.spacing12
        ),
        textAlign = TextAlign.Center,
        color = MaterialTheme.color.fontPrimary,
        style = MaterialTheme.typography.titleLarge,
        text = "How would you rate $movieName ?"
    )
    SpacerVertical(height = MaterialTheme.spacing.spacing24)
    Row(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        RatingBar(
            value = rating,
            painterEmpty = painterResource(id = R.drawable.rate_action_star),
            painterFilled = painterResource(id = R.drawable.rated_star),
            onValueChange = {
                rating = it
            },
            onRatingChanged = {
                Log.d("TAG", "onRatingChanged: $it")
            }
        )
    }
    SpacerVertical(height = MaterialTheme.spacing.spacing24)
    Row {
        PrimaryOutlinedButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            border = BorderStroke(
                width = MaterialTheme.dimens.dimens1,
                color = MaterialTheme.color.brand60
            ),
            text = "Cancel",
            textColor = MaterialTheme.color.brand100,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing8)
        PrimaryButton(
            modifier = Modifier
                .size(width = 110.dp, height = 36.dp),
            onClick = { },
            buttonColor = MaterialTheme.color.brand60,
            text = "Rate",
            textColor = MaterialTheme.color.fontSecondary,
            textStyle = MaterialTheme.typography.bodyMedium,
            buttonShape = RoundedCornerShape(MaterialTheme.radius.radius8)
        )
    }
}