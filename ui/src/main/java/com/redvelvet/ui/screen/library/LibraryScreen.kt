package com.redvelvet.ui.screen.library

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.composable.LoginRequired
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.NoContent
import com.redvelvet.ui.composable.PrimaryButton
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.theme.BackgroundCard
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.base.InvalidationErrorState
import com.redvelvet.viewmodel.library.LibraryUiEffect
import com.redvelvet.viewmodel.library.LibraryUiInteraction
import com.redvelvet.viewmodel.library.LibraryUiState
import com.redvelvet.viewmodel.library.LibraryViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LibraryScreen(libraryViewModel: LibraryViewModel = hiltViewModel()) {
    val state by libraryViewModel.state.collectAsState()
    rememberSystemUiController().setSystemBarsColor(Primary, darkIcons = false)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                title = stringResource(id = R.string.library_title_screen),
                hasBackArrow = false,
                modifier = Modifier.fillMaxWidth()
            )
        },
        containerColor = MaterialTheme.color.backgroundPrimary,
    ) { _ ->
        LibraryScreenContent(state, libraryViewModel)
        NavigationHandler(
            effects = libraryViewModel.effect,
            handleEffect = { effect, navController ->
                when (effect) {
                    is LibraryUiEffect.NavigateToMovie -> {
                        navController.navigateToMovieDetails("${effect.id}")
                    }

                    is LibraryUiEffect.NavigateToTvShow -> {}
                    is LibraryUiEffect.NavigateToLibrary -> navController.navigate(MovieDestination.Library.route)
                    is LibraryUiEffect.NavigateToList -> {}
                    is LibraryUiEffect.NavigateToLogin -> {
                        navController.navigateToLogin()
                    }
                }
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreenContent(state: LibraryUiState, interaction: LibraryUiInteraction) {
    val modalState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    var listId by rememberSaveable {
        mutableIntStateOf(0)
    }
    AnimatedVisibility(enter = fadeIn(), exit = fadeOut(), visible = state.isLoading) {
        LoadingState()
    }
    AnimatedVisibility(
        enter = fadeIn(),
        exit = fadeOut(),
        visible = !state.isLoading && state.error != null
    ) {
        when (state.error) {
            is InvalidationErrorState -> LoginRequired(retryButton = {
                PrimaryButton(
                    onClick = { interaction.onClickLogin() },
                    text = "Login"
                )
            })

            else -> NoContent(
                title = "Deleted Successfully",
                "Navigate back to Library"
            ) {
                PrimaryButton(onClick = { interaction.onClickGotoLibrary() }, text = "Goto Library")
            }
        }
    }
    AnimatedVisibility(
        enter = fadeIn(), exit = fadeOut(),
        visible = !state.isLoading && state.error == null
    ) {
        if (state.data != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = MaterialTheme.dimens.dimens80,
                        bottom = MaterialTheme.dimens.dimens70
                    )
            ) {
                item {
                    LibrarySectionsHeader(
                        icon = R.drawable.icon_laylist,
                        head = "WatchLists",
                        hasSub = false,
                    )
                }
                item {
                    WatchListsSection(
                        state.data!!.watchLists,
                        onClickPlayList = { interaction.onClickPlayList(it) },
                        onMenuClick = {
                            listId = it
                            isSheetOpen = !isSheetOpen
                        },
                    ) { interaction.onClickAddPlayList("Action Movies") }
                }
                item {
                    LibrarySectionsHeader(
                        icon = R.drawable.icon_favorite,
                        head = "Favorites",
                        hasSub = state.data!!.favoritesList.isEmpty(),
                    )
                }
                item {
                    FavItem(state.data!!.favoritesList) {
                        interaction.onClickFavItem(it)
                    }
                }
            }
        }
    }
    AnimatedVisibility(visible = isSheetOpen) {
        ModalBottomSheet(
            containerColor = Secondary,
            sheetState = modalState,
            onDismissRequest = { isSheetOpen = !isSheetOpen },
            shape = RoundedCornerShape(
                topStart = MaterialTheme.dimens.dimens16,
                topEnd = MaterialTheme.dimens.dimens16
            )
        ) {
            Column(modifier = Modifier.padding(horizontal = MaterialTheme.dimens.dimens16)) {
                BottomSheetItem(onClick = {
                    interaction.onClearList(listId)
                    isSheetOpen = false
                }, title = "Clear List", Color.White, R.drawable.icon_delete)
                BottomSheetItem(onClick = {
                    interaction.onDeleteList(listId)
                    isSheetOpen = false
                }, title = "Delete List", Color.Red, R.drawable.icon_delete)
            }
        }
    }
}

@Composable
fun WatchListsSection(
    lists: List<LibraryUiState.LibraryData.CreatedListUiState>,
    onClickPlayList: (Int) -> Unit,
    onMenuClick: (Int) -> Unit,
    onClickAddPlayList: () -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.dimens.dimens24),
        contentPadding = PaddingValues(horizontal = MaterialTheme.dimens.dimens16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.dimens8)
    ) {
        items(lists.size) {
            AnimatedVisibility(visible = lists.isNotEmpty()) {
                PlayListItem(lists[it], { onClickPlayList(lists[it].id) }) { id ->
                    onMenuClick(id)
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens100)
                    .width(MaterialTheme.dimens.dimens140)
                    .padding(bottom = MaterialTheme.dimens.dimens4)
                    .clickable { onClickAddPlayList() },
                colors = CardDefaults.cardColors(containerColor = BackgroundCard),
                shape = RoundedCornerShape(CornerSize(MaterialTheme.dimens.dimens16)),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_add_to_list),
                        contentDescription = "",
                        modifier = Modifier.padding(bottom = MaterialTheme.dimens.dimens4)
                    )
                    Text(
                        text = stringResource(id = R.string.addPl), style = Typography.displaySmall
                    )
                }
            }
        }
    }
}

@Composable
fun PlayListItem(
    item: LibraryUiState.LibraryData.CreatedListUiState,
    onClickPlayList: (Int) -> Unit,
    onMenuClick: (Int) -> Unit
) {
    AnimatedVisibility(visible = true, enter = fadeIn(), exit = fadeOut()) {
        Column(modifier = Modifier.width(MaterialTheme.dimens.dimens140)) {
            Card(
                modifier = Modifier
                    .height(MaterialTheme.dimens.dimens100)
                    .width(MaterialTheme.dimens.dimens140)
                    .padding(bottom = MaterialTheme.dimens.dimens4)
                    .clickable { onClickPlayList(item.id) },
                colors = CardDefaults.cardColors(containerColor = BackgroundCard),
                shape = RoundedCornerShape(CornerSize(MaterialTheme.dimens.dimens16)),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                        painter = rememberAsyncImagePainter(
                            model = item.posterPath, placeholder = painterResource(
                                id = R.drawable.room_placeholder
                            )
                        ),
                        contentDescription = "",
                    )
                    Card(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxHeight(0.4f)
                    ) {}
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MaterialTheme.dimens.dimens12)
                            .padding(bottom = MaterialTheme.dimens.dimens4)
                            .align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${item.itemCount} video", style = Typography.displaySmall
                        )
                        Image(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.icon_laylist),
                            contentDescription = ""
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    style = Typography.labelMedium,
                    color = FontSecondary,
                    maxLines = 2,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                IconButton(onClick = { onMenuClick(item.id) }) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.menu_dots),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun FavItem(
    list: List<LibraryUiState.LibraryData.WatchListUiState>,
    onClickFavItem: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.dimens.dimens24),
        contentPadding = PaddingValues(horizontal = MaterialTheme.dimens.dimens16),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.dimens8)
    ) {
        items(list.size) {
            Column(modifier = Modifier.width(MaterialTheme.dimens.dimens140)) {
                Card(
                    modifier = Modifier
                        .height(MaterialTheme.dimens.dimens100)
                        .width(MaterialTheme.dimens.dimens140)
                        .padding(bottom = MaterialTheme.dimens.dimens4)
                        .clickable { onClickFavItem(list[it].id) },
                    colors = CardDefaults.cardColors(containerColor = BackgroundCard),
                    shape = RoundedCornerShape(CornerSize(MaterialTheme.dimens.dimens16)),
                ) {
                    Image(
                        contentScale = ContentScale.Crop, painter = rememberAsyncImagePainter(
                            model = list[it].posterPath,
                            placeholder = painterResource(id = R.drawable.room_placeholder)
                        ), modifier = Modifier.fillMaxSize(), contentDescription = ""
                    )
                }
                Text(
                    text = list[it].name,
                    style = Typography.labelMedium,
                    color = FontSecondary
                )
            }
        }
    }
}

@Composable
fun LibrarySectionsHeader(
    icon: Int,
    head: String,
    hasSub: Boolean = true,
    subTitle: String = "This is EmptyList"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = MaterialTheme.dimens.dimens8,
                start = MaterialTheme.dimens.dimens16,
                end = MaterialTheme.dimens.dimens16
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderLabel(icon, head, hasSub, subTitle)
    }
}

@Composable
fun HeaderLabel(icon: Int, head: String, hasSub: Boolean = false, subTitle: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(MaterialTheme.dimens.dimens32)
                .padding(end = MaterialTheme.dimens.dimens8),
            painter = painterResource(id = icon),
            contentDescription = ""
        )
        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = head,
                style = Typography.headlineMedium
            )
            AnimatedVisibility(visible = hasSub) {
                Text(
                    text = subTitle, style = Typography.titleSmall, color = FontSecondary
                )
            }
        }
    }
}

@Composable
fun BottomSheetItem(onClick: () -> Unit, title: String, color: Color, icon: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = color)
        IconButton(
            onClick = { onClick() },
            colors = IconButtonDefaults.iconButtonColors(contentColor = color)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
    }
}


const val image =
    "https://img.wattpad.com/135dde1bf493a253f15b1b95e20c12a0b0549bcc/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f44656b78626e6f325278466148773d3d2d3535393531393331312e313532343063346236646431303861303338373333393438393037342e6a7067?s=fit&w=720&h=720"