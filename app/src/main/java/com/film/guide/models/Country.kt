package com.film.guide.models


import com.fasterxml.jackson.annotation.JsonProperty

data class Country(
    @JsonProperty("country")
    val country: String = ""
){
        override fun toString(): String {
            return this.country
        }
    }