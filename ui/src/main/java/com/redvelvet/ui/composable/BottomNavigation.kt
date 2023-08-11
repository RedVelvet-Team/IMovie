package com.redvelvet.ui.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.theme.BackgroundOnPrimary
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun currentDestination(navController: NavHostController): NavDestination? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination
}

@Composable
fun BottomNavBar(navController: NavHostController, visibility: Boolean) {
    val items by remember {
        mutableStateOf(
            listOf(
                MovieDestination.Home,
                MovieDestination.Search,
                MovieDestination.Category,
                MovieDestination.Game,
                MovieDestination.Library
            )
        )
    }

    AnimatedVisibility(visibility) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimens.dimens70)
                .background(MaterialTheme.color.backgroundPrimary)
                .shadow(
                    elevation = MaterialTheme.spacing.spacing2,
                    clip = false,
                )
                .drawBehind {
                    val strokeWidth = 2f
                    drawLine(
                        color = BackgroundOnPrimary,
                        start = Offset(-size.width, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }
            ,

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                BottomNavItem(
                    screen = screen,
                    currentDestination = currentDestination(navController = navController),
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun BottomNavItem(
    screen: MovieDestination,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    Icon(
        modifier = Modifier
            .clickable {
                navController.navigate(screen.route) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        painter = painterResource(if (selected) screen.isSelected!! else screen.isUnSelected!!),
        contentDescription = ""
    )
}