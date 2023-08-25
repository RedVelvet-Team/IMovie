package com.redvelvet.ui.screen.episode

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
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
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.composable.LoginRequired
import com.redvelvet.ui.composable.NetworkView
import com.redvelvet.ui.composable.NoContent
import com.redvelvet.ui.composable.SectionHeader
import com.redvelvet.ui.screen.actor_details.navigateToActorDetails
import com.redvelvet.ui.screen.login.navigateToLogin
import com.redvelvet.ui.screen.sellAllTopCast.navigateToSeeAllTopCast
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.base.InvalidationErrorState
import com.redvelvet.viewmodel.base.NetworkErrorState
import com.redvelvet.viewmodel.base.NullResultErrorState
import com.redvelvet.viewmodel.episode.EpisodeDetailsInteraction
import com.redvelvet.viewmodel.episode.EpisodeDetailsUiState
import com.redvelvet.viewmodel.episode.EpisodeDetailsViewModel
import com.redvelvet.viewmodel.utils.SeeAllMovie

@Composable
fun EpisodeDetailsScreen(episodeDetailsViewModel: EpisodeDetailsViewModel = hiltViewModel()) {
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)
    val state by episodeDetailsViewModel.state.collectAsState()
    EpisodeDetailsContent(state, object : EpisodeDetailsInteraction {
        override fun onClickBack() {
            navController.navigateUp()
        }

        override fun onClickFavorite(episodeID: Int) {
            /*TODO("Not yet implemented")*/
        }

        override fun onClickSave(episodeID: Int) {
            /*TODO("Not yet implemented")*/
        }

        override fun onClickTopCastSeeAll(topCastId: Int) {
            navController.navigateToSeeAllTopCast(topCastId.toString())
        }

        override fun onCLickImagesSeeAll(imagesId: Int) {
            /*TODO("Not yet implemented")*/
        }

        override fun onClickCast(castId: Int) {
            navController.navigateToActorDetails(castId.toString())
        }

        override fun onClickVideo(videoKey: String) {
            /*TODO("Not yet implemented")*/
        }


        override fun onCLickRefresh() {
            episodeDetailsViewModel.refresh()
        }

        override fun onLoginRequired() {
            navController.navigateToLogin()
        }
    })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeDetailsContent(state: EpisodeDetailsUiState, interaction: EpisodeDetailsInteraction) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
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
                                    state.data?.episodeDetails?.id ?: -1
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
                                    state.data?.episodeDetails?.id ?: -1
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
                is NullResultErrorState -> NoContent(retryButton = { interaction.onCLickRefresh() })
                is InvalidationErrorState -> LoginRequired(retryButton = { interaction.onLoginRequired() })
                is NetworkErrorState -> NetworkView(onClick = { interaction.onCLickRefresh() })
                else -> {}
            }
            NoContent(
                title = "Error Happen",
                description = state.isError?.message ?: ""
            ) {
                interaction.onCLickRefresh()
            }
        }
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            MaterialTheme.color.backgroundPrimary,
            darkIcons = false
        )
        AnimatedVisibility(
            visible = !state.isLoading && (state.isError == null),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = state.data!!.episodeDetails.stillPath,
                            placeholder = painterResource(id = R.drawable.image_placeholder)
                        ),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item { Details(state) }
                item {
                    SectionHeader(
                        label = "TopCast",
                        seeAllMovie = SeeAllMovie.TOP_CAST,
                        onClickSeeAll = {
                            interaction.onClickTopCastSeeAll(state.data?.episodeCast?.id ?: 0)
                        }, modifier = Modifier.padding(top = 16.dp)
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
                                    model = it.profilePath,
                                    placeholder = painterResource(id = R.drawable.image_placeholder)
                                ),
                                    contentDescription = "avatar",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(70.dp)
                                        .clip(CircleShape)
                                        .padding(bottom = 4.dp)
                                        .clickable { interaction.onClickCast(it.id) })
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
                        label = "Episode Images",
                        seeAllMovie = SeeAllMovie.TOP_CAST,
                        onClickSeeAll = {
                            interaction.onCLickImagesSeeAll(0)
                        },
                        modifier = Modifier.padding(top = 16.dp)
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
                                        model = it.filePath,
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
            Icon(
                painter = painterResource(id = R.drawable.icon_star_filled),
                contentDescription = "",
                modifier = Modifier.padding(end = 4.dp),
                tint = Color.Yellow
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "${state.data!!.episodeAccountStatus.rated}",
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