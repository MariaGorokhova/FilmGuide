package com.film.guide.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.film.guide.database.FilmDao
import com.film.guide.models.FilmEntity
import com.film.guide.screens.components.ListFilm
import com.film.guide.screens.components.Title
import kotlinx.coroutines.launch

@Composable
fun FavoriteScreen(dao: FilmDao) {
    val list by remember { dao.getFavorite() }.collectAsState(initial = emptyList())
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Title(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), text = "Избранное"
        )
        ListFilm(
            Modifier
                .fillMaxSize()
                .weight(1f), list = list
        ) { film: FilmEntity ->
            coroutineScope.launch {
                dao.insert(film.copy(isFavorite = !film.isFavorite))
            }
        }
    }
}