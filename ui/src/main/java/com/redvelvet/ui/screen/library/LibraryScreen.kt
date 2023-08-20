package com.redvelvet.ui.screen.library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.ItemBasicCardForDetailsScreens
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.login.LoginUiState
import com.redvelvet.viewmodel.utils.getFullImage
import com.redvelvet.viewmodel.utils.isPerson

@Composable
fun LibraryScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                title = "Library", hasBackArrow = false, modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = MaterialTheme.color.backgroundPrimary,
    ) { paddingValues ->
        LibraryContent(paddingValues = paddingValues)
    }
}

@Composable
private fun LibraryContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionCard()
        SectionCard()
        SectionCard()
    }
}

@Composable
fun LoginState() {
    Image(
        painter = painterResource(id = R.drawable.library_logo),
        contentDescription = "library logo"
    )
    Text(
        text = "Login Required",
        style = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32),
        textAlign = TextAlign.Center,
    )
    Text(
        text = "Use your account to enjoy the best app experience.",
        style = Typography.titleSmall.copy(color = MaterialTheme.color.fontSecondary),
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4),
        textAlign = TextAlign.Center,
    )

    Column(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32)
    ) {
        PrimaryButton(
            text = "Login",
            onClick = { /*TODO*/ },
        )
    }
}

@Composable
fun SectionCard() {
    Column(
        modifier = Modifier.height(166.dp)
    ) {
        Row(
            modifier = Modifier.height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icon_laylist),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "WatchList", modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null
            )
        }
        LazyRow(
            contentPadding = PaddingValues(
                top = MaterialTheme.spacing.spacing8,
                bottom = MaterialTheme.spacing.spacing8
            ),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing8,
                Alignment.CenterHorizontally
            )
        ) {
            items(4) {
                ItemBasicCardForDetailsScreens(
                    imagePainter = rememberAsyncImagePainter(model = R.drawable.image_placeholder),
                    modifier = Modifier
                        .width(MaterialTheme.dimens.dimens140)
                        .height(MaterialTheme.dimens.dimens100),
                    hasName = true,
                    name = "Ibrahim",
                    id = 1,
                    hasDateAndCountry = false,
                )
            }
        }
    }
}

@Preview
@Composable
fun SectionCardPrev() {
    SectionCard()
//        .width(MaterialTheme.dimens.dimens140)
//        .height(MaterialTheme.dimens.dimens100)
}