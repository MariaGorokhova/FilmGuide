package com.film.guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.film.guide.database.AppDatabase
import com.film.guide.database.FilmDao
import com.film.guide.models.FilmEntity
import com.film.guide.models.ListEntity
import com.film.guide.models.flat
import com.film.guide.navigation.BottomBar
import com.film.guide.navigation.NavigationHost
import com.film.guide.ui.theme.FilmGuideTheme
import kotlinx.coroutines.launch

val listEntities = listOf(ListEntity("Russia"), ListEntity("United States")).flat()
val genre = listOf(ListEntity("Drama"), ListEntity("Comedian")).flat()
val testList = listOf(
    FilmEntity(
        nameOriginal = "Film 1",
        countries = listEntities,
        genres = genre,
        ratingKinopoisk = 8.6,
        kinopoiskId = 1
    ),
    FilmEntity(
        nameOriginal = "Film 2",
        countries = listEntities,
        genres = genre,
        ratingKinopoisk = 9.7,
        kinopoiskId = 2
    ),
    FilmEntity(
        nameOriginal = "Film 3",
        countries = listEntities,
        genres = genre,
        ratingKinopoisk = 5.5,
        kinopoiskId = 3
    ),
    FilmEntity(nameOriginal = "Film 4", countries = listEntities, genres = genre, kinopoiskId = 4),
    FilmEntity(nameOriginal = "Film 5", countries = listEntities, genres = genre, kinopoiskId = 5),
    FilmEntity(nameOriginal = "Film 6", countries = listEntities, genres = genre, kinopoiskId = 6),
    FilmEntity(nameOriginal = "Film 7", countries = listEntities, genres = genre, kinopoiskId = 7),
    FilmEntity(nameOriginal = "Film 8", countries = listEntities, genres = genre, kinopoiskId = 8),
    FilmEntity(nameOriginal = "Film 9", countries = listEntities, genres = genre, kinopoiskId = 9),
)


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val filmDao = db.filmDao()

        lifecycleScope.launch {
            filmDao.insertAll(testList)
        }


        setContent {
            FilmGuideTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(filmDao)
                }
            }
        }
    }
}


@Composable
fun MainScreen(dao: FilmDao) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        NavigationHost(it, navController, dao)
    }
}

