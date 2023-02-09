package com.film.guide.models


import com.fasterxml.jackson.annotation.JsonProperty

data class Genre(
    @JsonProperty("genre")
    val genre: String = ""
) {
    override fun toString(): String {
        return this.genre
    }
}