package com.redvelvet.ui.screen.library

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.composable.PrimaryTextField
import com.redvelvet.ui.theme.BackgroundOnSecondary
import com.redvelvet.ui.theme.BackgroundSecondary
import com.redvelvet.ui.theme.Montserrat
import com.redvelvet.ui.theme.RoundedShape
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius

@Composable
fun LibraryScreens() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                title = "Library", hasBackArrow = false, modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = MaterialTheme.color.backgroundPrimary,
    ) { paddingValues ->
        WatchListDetailsScreen(paddingValues = paddingValues)
    }
}

@Composable
private fun LibraryContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WatchListScreen()
    }
}

@Composable
fun LoginState() {
    Column(
        //modifier = Modifier.padding(top = MaterialTheme.spacing.spacing32),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = painterResource(id = R.drawable.library_logo),
            contentDescription = "library logo"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Login Required",
            style = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
            modifier = Modifier.padding(top = MaterialTheme.dimens.dimens32),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Use your account to enjoy the best app experience.",
            style = Typography.titleSmall.copy(color = MaterialTheme.color.fontSecondary),
            modifier = Modifier.padding(top = MaterialTheme.dimens.dimens4),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            text = "Login",
            modifier = Modifier.width(110.dp),

            onClick = { /*TODO*/ },
        )
    }
}

@Composable
fun WatchListScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.library_logo),
                contentDescription = "library Empty"
            )
            Text(
                text = "Currently Empty",
                style = Typography.headlineLarge.copy(color = MaterialTheme.color.fontPrimary),
                modifier = Modifier.padding(top = MaterialTheme.dimens.dimens32),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Enjoy adding movies and TV shows to your Watchlist and get ready for an enjoyable viewing experience!",
                style = Typography.titleSmall.copy(color = MaterialTheme.color.fontSecondary),
                modifier = Modifier.padding(top = MaterialTheme.dimens.dimens4),
                textAlign = TextAlign.Center,
            )
        }

        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(32.dp)),
            containerColor = MaterialTheme.color.brand100,
            contentColor = Color.White
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun WatchListDetailsScreen(paddingValues: PaddingValues) {
    LazyColumn() {
        items(10) {
            MovieItemCard()
        }
    }
}

@Composable
fun MovieItemCard() {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(150.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = R.drawable.wallpaper),
                contentDescription = stringResource(R.string.poster),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Icon",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(32.dp)
                    .background(Color.Black.copy(alpha = 0.5f), shape = CircleShape)
            )
            Text(
                text = "03:20",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
                    .background(Color.Black.copy(alpha = 0.5f), shape = RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            Text(text = "Movie Title", fontWeight = FontWeight.Bold)
            Text(
                text = "Shaun Murphy, a young surgeon with autism and savant syndrome, relocates from a quiet country life to join a prestigious hospital's surgical unit. Unable to personally connect with those around him, ..",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun AddNewListDialog(
    value: String,
    onTextChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.color.backgroundPrimary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create a new list",
            fontFamily = Montserrat,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Create a new list and keep track of your movies that you want to access easily",
            fontFamily = Montserrat,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryTextField(
            value = value,
            onTextChange = onTextChange,
            placeHolderText = "Add new List",
            isError = false
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens56),
                onClick = { },
                colors = ButtonDefaults.buttonColors(MaterialTheme.color.backgroundPrimary),
                shape = RoundedCornerShape(MaterialTheme.radius.radius16),
                enabled = true,
                border = BorderStroke(2.dp, MaterialTheme.color.brand100)
            ) {
                Text(
                    text = "Cancel",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(MaterialTheme.dimens.dimens4),
                    style = Typography.headlineMedium.copy(color = MaterialTheme.color.fontSecondary)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens56),
                onClick = { },
                colors = ButtonDefaults.buttonColors(MaterialTheme.color.brand100),
                shape = RoundedCornerShape(MaterialTheme.radius.radius16),
                enabled = true,
            ) {
                Text(
                    text = "Confirm",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(MaterialTheme.dimens.dimens4),
                    style = Typography.headlineMedium.copy(color = MaterialTheme.color.fontSecondary)
                )
            }
        }

    }
}

@Composable
fun SectionCard(
    title: String,
    iconId: Int,
    isWatchList: Boolean = false,
    showBlur: Boolean = false,
    isEmpty: Boolean
) {
    Column(
        modifier = Modifier.height(166.dp),

        ) {
        Row(
            modifier = Modifier.height(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = iconId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontSize = 18.sp
            )
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = null
            )
        }
        if (isEmpty) {
            Row(
                Modifier.padding(start = 32.dp)
            ) {
                Text(
                    text = "The List Is Empty",
                    fontFamily = Montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        } else {
            LazyRow(
                contentPadding = PaddingValues(
                    top = MaterialTheme.dimens.dimens8,
                    bottom = MaterialTheme.dimens.dimens8
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    MaterialTheme.dimens.dimens8,
                    Alignment.CenterHorizontally
                )
            ) {
                if (isWatchList) {
                    item {
                        Surface(
                            modifier = Modifier
                                .height(100.dp)
                                .width(140.dp),
                            shape = RoundedShape.medium,
                            color = BackgroundSecondary
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Surface(
                                    modifier = Modifier.size(36.dp),
                                    shape = RoundedShape.extraLarge
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(12.dp)
                                            .background(BackgroundOnSecondary),
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "Add",
                                        tint = Color.White
                                    )
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Add Playlist", maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = MaterialTheme.color.fontSecondary,
                                    style = Typography.labelSmall
                                )
                            }
                        }
                    }
                }

                items(4) {
                    ItemBasicCardForLibrary(
                        imagePainter = rememberAsyncImagePainter(model = R.drawable.wallpaper),
                        modifier = Modifier
                            .width(MaterialTheme.dimens.dimens140)
                            .height(MaterialTheme.dimens.dimens100),
                        id = 1,
                        name = "Ibrahim",
                        showBlur = showBlur
                    )
                }
            }
        }
    }
}

@Composable
fun ItemBasicCardForLibrary(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    name: String = "",
    showBlur: Boolean = false,
    id: Int,
    onClick: (id: Int) -> Unit = {},
    isMediaInfoCard: Boolean = false
) {
    Column(
        modifier = if (isMediaInfoCard) Modifier else Modifier
            .clickable { onClick(id) },
        horizontalAlignment = AbsoluteAlignment.Left
    ) {
        Box(
            modifier = modifier.clip(RoundedCornerShape(16.dp))
        ) {
            // Image
            Image(
                painter = imagePainter,
                contentDescription = stringResource(R.string.poster),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            if (showBlur) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.2f)
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(Color.White.copy(alpha = 0.3f))
                ) {
                    Row(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            text = "10 Videos",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .width(MaterialTheme.dimens.dimens104)
                                .padding(
                                    bottom = MaterialTheme.dimens.dimens2,
                                    top = MaterialTheme.dimens.dimens4
                                )
                        )
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.icon_laylist),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        }
        Text(
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.color.fontSecondary,
            style = Typography.labelMedium,
            modifier = Modifier
                .width(MaterialTheme.dimens.dimens104)
                .padding(
                    bottom = MaterialTheme.dimens.dimens2,
                    top = MaterialTheme.dimens.dimens4
                )
        )

    }
}


@Preview
@Composable
fun SectionCardPrev() {
    MovieItemCard()
}