package com.redvelvet.ui.composable

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.navigation.MovieDestination
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun currentDestination(): NavDestination? {
    val navBackStackEntry by LocalNavController.current.currentBackStackEntryAsState()
    return navBackStackEntry?.destination
}

@Composable
fun BottomNavBar(visibility: Boolean) {
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

    if (visibility) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimens.dimens70)
                .background(MaterialTheme.color.backgroundPrimary)
                .shadow(
                    elevation = MaterialTheme.spacing.spacing2,
                    spotColor = Color.White,
                    clip = false
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                BottomNavItem(
                    screen = screen,
                    currentDestination = currentDestination(),
                )
            }
        }
    }
}

@Composable
fun BottomNavItem(
    screen: MovieDestination,
    currentDestination: NavDestination?,
) {
    val navController = LocalNavController.current
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val backDispatcherOwner = LocalOnBackPressedDispatcherOwner.current
    val currentDestination = remember { mutableStateOf(MovieDestination.Home.route) }
    backDispatcherOwner?.let { dispatcherOwner ->
        val backCallback = remember {
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (currentDestination.value == MovieDestination.Home.route) {
                        isEnabled = true
                        dispatcherOwner.onBackPressedDispatcher.onBackPressed()
                    }
                    if (currentDestination.value == MovieDestination.Search.route) {
                        navController.navigate(MovieDestination.Home.route) {
                            popUpTo(navController.graph.startDestinationRoute ?: return@navigate) {
                                inclusive = true
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            }
        }
        DisposableEffect(Lifecycle.State.CREATED) {
            dispatcherOwner.onBackPressedDispatcher.addCallback(backCallback)
            onDispose { backCallback.remove() }
        }
    }
    Icon(
        modifier = Modifier
            .clickable {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        painter = painterResource(if (selected) screen.isSelected!! else screen.isUnSelected!!),
        contentDescription = ""
    )
}