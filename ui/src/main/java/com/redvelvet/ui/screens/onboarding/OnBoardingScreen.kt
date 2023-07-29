package com.redvelvet.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.redvelvet.ui.R
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screens.onboarding.composable.CustomButton
import com.redvelvet.ui.screens.onboarding.composable.CustomText
import com.redvelvet.ui.screens.onboarding.composable.VerticalSpacer
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    navController: NavController
) {
    OnBoardingContent { navController.navigate(MovieDestination.Login.route) }
}

@Composable
private fun OnBoardingContent(
    onStartClick: () -> Unit,
) {
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
            CustomText(
                name = stringResource(R.string.name_app),
                modifier =
                Modifier.padding(top = 16.dp),
                style = Typography.headlineLarge.copy(color = FontPrimary),
            )
            CustomText(
                name = stringResource(R.string.description),
                modifier = Modifier
                    .padding(horizontal = 62.dp),
                style = Typography.titleSmall.copy(color = FontSecondary),
            )
            VerticalSpacer(space = 160)
            CustomButton(
                text = stringResource(R.string.onboarding_start),
                onClick = { onStartClick() })
        }
    }

}
