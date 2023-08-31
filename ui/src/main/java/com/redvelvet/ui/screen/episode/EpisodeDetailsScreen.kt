package com.redvelvet.ui.screen.episode

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.NetworkView
import com.redvelvet.ui.composable.NoContent
import com.redvelvet.ui.composable.SectionHeader
import com.redvelvet.ui.screen.actor_details.navigateToActorDetails
import com.redvelvet.ui.screen.seeAllMovieImages.navigateToSeeAllImages
import com.redvelvet.ui.screen.sellAllTopCast.navigateToSeeAllTopCast
import com.redvelvet.ui.screen.youtube_player.navigateToYoutubePlayer
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.ui.util.MovieWebViewUrls
import com.redvelvet.viewmodel.base.NetworkErrorState
import com.redvelvet.viewmodel.episode.EpisodeDetailsInteraction
import com.redvelvet.viewmodel.episode.EpisodeDetailsUiEffect
import com.redvelvet.viewmodel.episode.EpisodeDetailsUiState
import com.redvelvet.viewmodel.episode.EpisodeDetailsViewModel
import com.redvelvet.viewmodel.utils.MediaType
import com.redvelvet.viewmodel.utils.SeeAllMovie
import com.redvelvet.viewmodel.utils.SeeAllTvShows

private const val IMAGE_HEIGHT = 250
@Composable
fun EpisodeDetailsScreen(episodeDetailsViewModel: EpisodeDetailsViewModel = hiltViewModel()) {
    rememberSystemUiController().setSystemBarsColor(Primary, darkIcons = false)
    val state by episodeDetailsViewModel.state.collectAsState()
    EpisodeDetailsContent(state, episodeDetailsViewModel)
    NavigationHandler(
        effects = episodeDetailsViewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is EpisodeDetailsUiEffect.NavigateUp -> {
                    navController.popBackStack()
                }

                is EpisodeDetailsUiEffect.NavigateToCastDetailsScreen -> {
                    navController.navigateToActorDetails(effect.id)
                }

                is EpisodeDetailsUiEffect.NavigateToImageScreen -> {}
                is EpisodeDetailsUiEffect.NavigateToSeeAllCastDetailsScreen -> {
                    navController.navigateToSeeAllTopCast(effect.id)
                }

                is EpisodeDetailsUiEffect.NavigateToSeeAllImagesScreen -> {
                    navController.navigateToSeeAllImages()
                }

                is EpisodeDetailsUiEffect.NavigateToVideoScreen -> {
                    navController.navigateToYoutubePlayer(effect.key)
                }
            }
        })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeDetailsContent(state: EpisodeDetailsUiState, interaction: EpisodeDetailsInteraction) {
    val listState = rememberLazyListState()
    val isScrolled by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 250
        }
    }
    val topAppColor = animateColorAsState(
        targetValue = if (isScrolled) Primary else Color.Transparent,
        label = ""
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topAppColor.value
                ),
                actions = {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_back),
                            contentDescription = "Back",
                            modifier = Modifier.clickable { interaction.onClickBack() },
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.icon_favorite),
                            contentDescription = "Favorite",
                            modifier = Modifier.clickable {
                                interaction.onClickFavorite(
                                    "${state.data?.episodeDetails?.id}"
                                )
                            },
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spacing24))
                        Icon(
                            painter = painterResource(id = R.drawable.icon_save),
                            contentDescription = "Save",
                            modifier = Modifier.clickable {
                                interaction.onClickSave(
                                    "${state.data?.episodeDetails?.id}"
                                )
                            },
                            tint = Color.White
                        )
                    }
                })
        }, containerColor = Primary
    ) {
        AnimatedVisibility(
            visible = state.isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LoadingState()
        }
        AnimatedVisibility(
            visible = state.isError != null,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            when (state.isError) {
                is NetworkErrorState -> NetworkView(onClick = { interaction.onCLickRefresh() })
                else -> {
                    NoContent()
                }
            }
            NoContent(
                title = "Error Happen",
                description = state.isError?.message ?: ""
            ) {
                interaction.onCLickRefresh()
            }
        }
        AnimatedVisibility(
            visible = !state.isLoading && (state.isError == null),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = MovieWebViewUrls.IMAGES_URL + state.data!!.episodeDetails.stillPath,
                        placeholder = painterResource(id = R.drawable.image_placeholder)
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IMAGE_HEIGHT.dp)
                )
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = if (isScrolled) Primary else Color.Transparent)
                ) {
                    item { Details(state) }
                    item {
                        SectionHeader(
                            modifier = Modifier.padding(top = 16.dp),
                            label = "TopCast",
                            onClickSeeAllMovie = {
                                interaction.onClickTopCastSeeAll("${state.data?.episodeCast?.id}")
                            }, seeAllMovie = SeeAllMovie.TOP_CAST, onClickSeeAllTv = {  },
                                    type = MediaType.MOVIE, seeAllTv = SeeAllTvShows.POPULAR
                        )
                    }
                    item {
                        LazyRow(
                            modifier = Modifier.padding(top = 8.dp),
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(state.data!!.episodeCast.cast) {
                                Column(modifier = Modifier.width(70.dp)) {
                                    Image(painter = rememberAsyncImagePainter(
                                        model = MovieWebViewUrls.IMAGES_URL + it.profilePath,
                                        placeholder = painterResource(id = R.drawable.image_placeholder)
                                    ),
                                        contentDescription = "avatar",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(70.dp)
                                            .clip(CircleShape)
                                            .padding(bottom = 4.dp)
                                            .clickable { interaction.onClickCast("${it.id}") })
                                    Text(
                                        text = it.name,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = FontSecondary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                    item {
                        SectionHeader(
                            modifier = Modifier.padding(top = 16.dp),
                            label = "Episode Images",
                            onClickSeeAllMovie = {
                                interaction.onCLickImagesSeeAll("0")
                            },
                            seeAllMovie = SeeAllMovie.TOP_CAST,
                            onClickSeeAllTv = {},
                            type = MediaType.MOVIE,
                            seeAllTv = SeeAllTvShows.ON_TV
                        )
                    }
                    item {
                        LazyRow(
                            modifier = Modifier.padding(top = 8.dp),
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(state.data!!.episodeImages.stills) {
                                Column(modifier = Modifier.width(112.dp)) {
                                    Image(
                                        painter = rememberAsyncImagePainter(
                                            model = MovieWebViewUrls.IMAGES_URL + it.filePath,
                                            placeholder = painterResource(id = R.drawable.image_placeholder)
                                        ),
                                        contentDescription = "avatar",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(112.dp)
                                            .clip(RoundedCornerShape(CornerSize(16.dp)))
                                            .padding(bottom = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                    item {
                        Text(
                            text = "Videos",
                            style = Typography.titleMedium,
                            color = Color.White,
                            modifier = Modifier.padding(
                                start = 16.dp,
                                bottom = 8.dp
                            )
                        )
                    }
                    items(
                        state.data!!.episodeMovies.results
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 4.dp
                                )
                                .clickable { interaction.onClickVideo(it.key) },
                            colors = CardDefaults.cardColors(containerColor = Secondary)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 16.dp),
                                Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = it.name,
                                        style = Typography.labelMedium,
                                        color = Color.White,
                                        modifier = Modifier.padding(
                                        )
                                    )
                                    Text(
                                        text = "${it.site}, ${it.type}",
                                        style = Typography.labelSmall,
                                        color = FontSecondary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        modifier = Modifier.padding(
                                        )
                                    )
                                }
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_back),
                                    contentDescription = "Back",
                                    modifier = Modifier
                                        .rotate(180f),
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Details(
    state: EpisodeDetailsUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(IMAGE_HEIGHT.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = state.data!!.episodeDetails.name,
                style = Typography.titleMedium,
                color = Color.White,
            )
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
                    .background(color = Secondary)
                    .padding(
                        vertical = MaterialTheme.spacing.spacing4,
                        horizontal = MaterialTheme.spacing.spacing8
                    ),
                text = "se ${state.data!!.episodeDetails.seasonNumber}, ep ${state.data!!.episodeDetails.episodeNumber}",
                style = MaterialTheme.typography.bodyMedium,
                color = FontSecondary,
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_date),
                contentDescription = "",
                tint = Color.White
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = state.data!!.episodeDetails.airDate,
                style = MaterialTheme.typography.bodyMedium,
                color = FontSecondary,
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_star_filled),
                contentDescription = "",
                modifier = Modifier.padding(end = 4.dp),
                tint = Color.Yellow
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 8.dp),
                text = "${state.data!!.episodeDetails.voteAverage} Rating",
                style = MaterialTheme.typography.bodyMedium,
                color = FontSecondary,
            )
        }
        Text(
            text = state.data!!.episodeDetails.overview,
            style = MaterialTheme.typography.bodyMedium,
            color = FontSecondary,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}