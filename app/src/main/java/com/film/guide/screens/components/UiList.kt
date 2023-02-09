package com.film.guide.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.film.guide.R
import com.film.guide.models.Film
import com.film.guide.screens.films.country
import com.film.guide.screens.films.genre
import com.film.guide.ui.theme.*


@Composable
fun ListFilm(modifier: Modifier, list: List<Film>) {
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(16.dp)) {
        items(list) {
            FilmItem(modifier = Modifier.fillMaxWidth(), it)
        }
    }
}

@Composable
fun FilmItem(modifier: Modifier, film: Film) {
    Row(modifier.padding(vertical = 8.dp)) {
        ImageFilm(film)
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = film.nameRu ?: film.nameOriginal,
                style = h2
            )
            Text(
                text = film.genres.flat(),
                style = title
            )
            Text(
                text = film.countries.flat(),
                style = title.copy(color = textLightGray)
            )
            Text(
                text = film.year.toString(),
                style = title.copy(color = textDark)
            )
        }
    }
}

@Composable
fun RowScope.ImageFilm(film: Film) {
    Box(
        modifier = Modifier.weight(1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Poster",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(Shapes.small)
        )
        if (film.ratingKinopoisk != null) {
            Text(
                modifier = Modifier
                    .clip(Shapes.small)
                    .background(Color.Green)
                    .padding(4.dp)
                    .align(Alignment.BottomEnd),
                style = p,
                text = film.ratingKinopoisk.toString()
            )
        }

    }

}

@Composable
fun Title(modifier: Modifier, text: String) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = text, style = h1)
    }
}


private fun <T> List<T>.flat(): String {
    return this.joinToString(separator = ", ") { it.toString() }
}


@Preview
@Composable
fun ListItemPreview() {
    ListFilm(
        modifier = Modifier.fillMaxWidth().background(color = Color.White), list = listOf(
            Film(
                nameOriginal = "Film 1",
                countries = country,
                genres = genre,
                ratingKinopoisk = 8.6
            ),
            Film(
                nameOriginal = "Film 2",
                countries = country,
                genres = genre,
                ratingKinopoisk = 9.7
            ),
            Film(
                nameOriginal = "Film 3",
                countries = country,
                genres = genre,
                ratingKinopoisk = 5.5
            ),
            Film(nameOriginal = "Film 4", countries = country, genres = genre),
            Film(nameOriginal = "Film 5", countries = country, genres = genre),
            Film(nameOriginal = "Film 6", countries = country, genres = genre),
            Film(nameOriginal = "Film 7", countries = country, genres = genre),
            Film(nameOriginal = "Film 8", countries = country, genres = genre),
            Film(nameOriginal = "Film 9", countries = country, genres = genre),
        )
    )
}