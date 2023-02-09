package com.film.guide.models


import com.fasterxml.jackson.annotation.JsonProperty

data class KinopoiskResult(
    @JsonProperty("items")
    val films: List<Film> = listOf(),
    @JsonProperty("total")
    val total: Int = 0,
    @JsonProperty("totalPages")
    val totalPages: Int = 0
)