package com.redvelvet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius

@Composable
fun onBoardingScreen() {
    onBoardingContent()
}

@Composable
fun onBoardingContent() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.wallpaper),
            contentDescription = stringResource(R.string.background_image_onboarding),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.vector_logo),
                contentDescription = stringResource(R.string.movie_logo),
                modifier = Modifier
                    .width(70.dp)
                    .height(78.dp),
            )
            VerticalSpacer(space = 16)
            Text(
                text = stringResource(R.string.name_app),
                style = Typography.headlineLarge.copy(color = FontPrimary),
                textAlign = TextAlign.Center
            )
            VerticalSpacer(space = 16)
            Text(
                text =
                stringResource(R.string.description),
                style = Typography.titleSmall.copy(color = FontSecondary),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 62.dp)
            )
            VerticalSpacer(space = 160)
            CustomButton(text = stringResource(R.string.onboarding_start), onClick = { /*TODO*/ })
        }
    }

}

@Composable
fun VerticalSpacer(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = Purple100,
    textColor: Color = FontSecondary
) {
    Button(
        modifier = Modifier
            .height(49.dp)
            .width(110.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(MaterialTheme.radius.radius16)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(4.dp),
            style = Typography.bodyMedium.copy(color = textColor)
        )

    }
}

@Preview
@Composable
fun PreviewOnBoarding() {

}