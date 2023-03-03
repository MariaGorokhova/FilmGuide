package com.film.guide.screens.components

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.film.guide.R
import com.film.guide.genre
import com.film.guide.listEntities
import com.film.guide.models.FilmEntity
import com.film.guide.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListFilm(
    modifier: Modifier, list: List<FilmEntity>, onFavoriteClick: (FilmEntity) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
    ) {
        items(list, key = { it.kinopoiskId }) {
            FilmItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateItemPlacement(),
                it,
                onFavoriteClick = onFavoriteClick
            )
        }
    }
}

@Composable
fun FilmItem(modifier: Modifier, film: FilmEntity, onFavoriteClick: (FilmEntity) -> Unit) {
    Row(modifier.padding(vertical = 8.dp)) {
        ImageFilm(film)
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = film.nameRu ?: film.nameOriginal, style = h2
            )
            if (film.genres.isNotBlank()) {
                Text(
                    text = film.genres, style = title
                )
            }
            if (film.countries.isNotBlank()) {
                Text(
                    text = film.countries, style = title.copy(color = textLightGray)
                )
            }


            if (film.year != 0) {
                Text(
                    text = film.year.toString(), style = title.copy(color = textDark)
                )
            }


            Text(text = if (film.isFavorite) "убрать из избр." else "добавить в избр.",
                style = title.copy(color = textLightGray, textAlign = TextAlign.End),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = {
                        onFavoriteClick(film)
                    })
                    .padding(vertical = 10.dp))


        }
    }
}

@Composable
fun RowScope.ImageFilm(film: FilmEntity) {
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
                    .align(Alignment.BottomEnd), style = p, text = film.ratingKinopoisk.toString()
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

@Preview
@Composable
fun ListItemPreview() {
    ListFilm(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White), list = listOf(
            FilmEntity(
                nameOriginal = "Film 1",
                countries = listEntities,
                genres = genre,
                ratingKinopoisk = 8.6
            ),
            FilmEntity(
                nameOriginal = "Film 2",
                countries = listEntities,
                genres = genre,
                ratingKinopoisk = 9.7
            ),
            FilmEntity(
                nameOriginal = "Film 3",
                countries = listEntities,
                genres = genre,
                ratingKinopoisk = 5.5
            ),
            FilmEntity(nameOriginal = "Film 4", countries = listEntities, genres = genre),
            FilmEntity(nameOriginal = "Film 5", countries = listEntities, genres = genre),
            FilmEntity(nameOriginal = "Film 6", countries = listEntities, genres = genre),
            FilmEntity(nameOriginal = "Film 7", countries = listEntities, genres = genre),
            FilmEntity(nameOriginal = "Film 8", countries = listEntities, genres = genre),
            FilmEntity(nameOriginal = "Film 9", countries = listEntities, genres = genre),
        )
    )
}