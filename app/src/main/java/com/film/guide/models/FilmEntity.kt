package com.film.guide.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

@Entity("film")
data class FilmEntity(
    val countries: String,
    val genres: String,
    val imdbId: String? = null,
    @PrimaryKey(autoGenerate = true) val kinopoiskId: Int = 0,
    val nameEn: String? = null,
    val nameOriginal: String = "",
    val nameRu: String? = null,
    val posterUrl: String = "",
    val posterUrlPreview: String = "",
    val ratingImdb: String? = null,
    val ratingKinopoisk: Double? = null,
    val type: String = "", val year: Int = 0,
    val isFavorite: Boolean = false
)

fun Film.toEntity(): FilmEntity {
    return FilmEntity(
        countries = this.countries.flat(),
        genres = this.genres.flat(),
        imdbId = this.imdbId,
        kinopoiskId = this.kinopoiskId,
        nameEn = this.nameRu,
        nameOriginal = this.nameOriginal,
        nameRu = this.nameRu,
        posterUrl = this.posterUrl,
        posterUrlPreview = this.posterUrlPreview,
        ratingImdb = this.ratingImdb,
        ratingKinopoisk = this.ratingKinopoisk,
        type = this.type,
        year = this.year,
    )
}

fun <T> List<T>.flat(): String {
    return this.joinToString(separator = ", ") { it.toString() }
}

fun String.toList(separator: String = ", "): List<ListEntity> {
    return this.split(separator).map { ListEntity(it) }
}


