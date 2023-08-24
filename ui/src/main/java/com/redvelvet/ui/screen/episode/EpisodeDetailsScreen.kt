package com.redvelvet.ui.screen.episode

import android.annotation.SuppressLint
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.SectionHeader
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.episode.EpisodeDetails
import com.redvelvet.viewmodel.episode.EpisodeDetailsViewModel
import com.redvelvet.viewmodel.utils.SeeAllMovie

@Composable
fun EpisodeDetailsScreen() {
    val navController = LocalNavController.current
    val context = LocalContext.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeDetailsContent(

) {
    val state = EpisodeDetailsViewModel().fakeEpisodeDetails
    Scaffold(
        topBar = {
            TopAppBar(title = { },
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
                            modifier = Modifier.clickable { /*TODO*/ },
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.icon_favorite),
                            contentDescription = "Favorite",
                            modifier = Modifier.clickable { /*TODO*/ },
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(MaterialTheme.spacing.spacing24))
                        Icon(
                            painter = painterResource(id = R.drawable.icon_save),
                            contentDescription = "Save",
                            modifier = Modifier.clickable { /*TODO*/ },
                            tint = Color.White
                        )
                    }
                })
        }, containerColor = Primary
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = state.episodeDetails.stillPath,
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
                    label = "TopCast", seeAllMovie = SeeAllMovie.TOP_CAST, onClickSeeAll = {
                        /*TODO*/
                    }, modifier = Modifier.padding(top = 16.dp)
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.episodeCast.cast) {
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
                                    .clickable { /*TODO*/ })
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
                    label = "Episode Images", seeAllMovie = SeeAllMovie.TOP_CAST, onClickSeeAll = {
                        /*TODO*/
                    }, modifier = Modifier.padding(top = 16.dp)
                )
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.episodeImages.stills) {
                        Column(modifier = Modifier.width(112.dp)) {
                            Image(painter = rememberAsyncImagePainter(
                                model = it.filePath,
                                placeholder = painterResource(id = R.drawable.image_placeholder)
                            ),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(112.dp)
                                    .clip(RoundedCornerShape(CornerSize(16.dp)))
                                    .padding(bottom = 4.dp)
                                    .clickable { /*TODO*/ })
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
                state.episodeMovies.results
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp
                        )
                        .clickable { /*TODO*/ },
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


@Composable
fun Details(
    state: EpisodeDetails,
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
                text = state.episodeDetails.name,
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
                text = "se ${state.episodeDetails.seasonNumber}, ep ${state.episodeDetails.episodeNumber}",
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
                text = state.episodeDetails.airDate,
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
                text = "${state.episodeDetails.voteAverage} Rating",
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
                text = "${state.episodeAccountStatus.rated}",
                style = MaterialTheme.typography.bodyMedium,
                color = FontSecondary,
            )
        }
        Text(
            text = state.episodeDetails.overview,
            style = MaterialTheme.typography.bodyMedium,
            color = FontSecondary,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = true, device = "spec:width=360dp,height=800dp"
)
@Composable
fun Test() {
    EpisodeDetailsContent()
}


