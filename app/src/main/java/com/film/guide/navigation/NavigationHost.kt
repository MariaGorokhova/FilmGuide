package com.film.guide.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.film.guide.R
import com.film.guide.database.FilmDao
import com.film.guide.screens.favorite.FavoriteScreen
import com.film.guide.screens.films.FilmScreen
import com.film.guide.screens.map.MapScreen

sealed class Screen(val route: String, val name: String, val iconId: Int) {
    object FilmScreen : Screen("film_screen", "Фильмы", R.drawable.film_icon)
    object FavoriteScreen :
        Screen("favorite_screen", "Избранное", R.drawable.favorite_icon)

    object MapScreen : Screen("map_screen", "Кинотеатры", R.drawable.map_icon)
}

@Composable
fun NavigationHost(paddingValues: PaddingValues, navController: NavHostController, dao: FilmDao) {
    NavHost(
        navController = navController,
        startDestination = Screen.FilmScreen.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Screen.FilmScreen.route) { FilmScreen(dao) }
        composable(Screen.FavoriteScreen.route) { FavoriteScreen(dao) }
        composable(Screen.MapScreen.route) { MapScreen() }
    }
}