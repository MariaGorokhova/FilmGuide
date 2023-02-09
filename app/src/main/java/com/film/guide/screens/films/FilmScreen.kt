package com.film.guide.screens.films

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.film.guide.models.Country
import com.film.guide.models.Film
import com.film.guide.models.Genre
import com.film.guide.screens.components.ListFilm
import com.film.guide.screens.components.Title

val country = listOf(Country("Russia"), Country("United States"))
val genre = listOf(Genre("Drama"), Genre("Comedian"))
val testList = listOf(
    Film(nameOriginal = "Film 1", countries = country, genres = genre, ratingKinopoisk = 8.6),
    Film(nameOriginal = "Film 2", countries = country, genres = genre, ratingKinopoisk = 9.7),
    Film(nameOriginal = "Film 3", countries = country, genres = genre, ratingKinopoisk = 5.5),
    Film(nameOriginal = "Film 4", countries = country, genres = genre),
    Film(nameOriginal = "Film 5", countries = country, genres = genre),
    Film(nameOriginal = "Film 6", countries = country, genres = genre),
    Film(nameOriginal = "Film 7", countries = country, genres = genre),
    Film(nameOriginal = "Film 8", countries = country, genres = genre),
    Film(nameOriginal = "Film 9", countries = country, genres = genre),
)

@Preview
@Composable
fun FilmScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Title(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = "Фильмы"
        )
        ListFilm(
            Modifier
                .fillMaxSize()
                .weight(1f), list = testList
        )
    }
}