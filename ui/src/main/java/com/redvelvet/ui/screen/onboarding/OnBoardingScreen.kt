package com.redvelvet.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomButton
import com.redvelvet.ui.composable.CustomText
import com.redvelvet.ui.composable.WallPaper
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.viewmodel.onboarding.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: OnBoardingViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    OnBoardingContent {
        if (state.saved)
            navController.navigate(MovieDestination.Login.route)
    }
}

@Composable
private fun OnBoardingContent(
    onStartClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        WallPaper(id = R.drawable.wallpaper)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector_logo),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier.size(height = 78.dp, width = 78.dp),
            )
            CustomText(
                name = stringResource(R.string.name_app),
                modifier = Modifier.padding(vertical = 16.dp),
                style = Typography.headlineLarge.copy(color = FontPrimary),
            )
            CustomText(
                name = stringResource(R.string.description),
                style = Typography.titleSmall.copy(color = FontSecondary, lineHeight = 16.sp),
            )
        }
        Column(
            modifier = Modifier.padding(bottom = 64.dp)
        ) {
            CustomButton(
                text = stringResource(R.string.onboarding_start),
                onClick = { onStartClick() })
        }
    }
}
