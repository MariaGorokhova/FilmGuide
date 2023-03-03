package com.film.guide.models


import com.fasterxml.jackson.annotation.JsonProperty

data class Film(
    @JsonProperty("countries")
    val countries: List<ListEntity> = listOf(),
    @JsonProperty("genres")
    val genres: List<ListEntity> = listOf(),
    @JsonProperty("imdbId")
    val imdbId: String? = null,
    @JsonProperty("kinopoiskId")
    val kinopoiskId: Int = 0,
    @JsonProperty("nameEn")
    val nameEn: String? = null,
    @JsonProperty("nameOriginal")
    val nameOriginal: String = "",
    @JsonProperty("nameRu")
    val nameRu: String? = null,
    @JsonProperty("posterUrl")
    val posterUrl: String = "",
    @JsonProperty("posterUrlPreview")
    val posterUrlPreview: String = "",
    @JsonProperty("ratingImdb")
    val ratingImdb: String? = null,
    @JsonProperty("ratingKinopoisk")
    val ratingKinopoisk: Double? = null,
    @JsonProperty("type")
    val type: String = "",
    @JsonProperty("year")
    val year: Int = 0
)