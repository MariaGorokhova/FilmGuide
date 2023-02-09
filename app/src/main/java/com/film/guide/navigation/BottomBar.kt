package com.film.guide.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.film.guide.R
import com.film.guide.ui.theme.textDark

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        Screen.FilmScreen, Screen.FavoriteScreen, Screen.MapScreen
    )

    BottomNavigation(backgroundColor = Color.White, contentColor = contentColorFor(backgroundColor = textDark)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(icon = {
                Icon(
                    painter = painterResource(id = screen.iconId), contentDescription = null
                )
            },
                label = { Text(screen.name) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}