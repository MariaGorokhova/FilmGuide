package com.film.guide.models


import com.fasterxml.jackson.annotation.JsonProperty

data class ListEntity(
    @JsonProperty("country")
    val name: String = ""
){
        override fun toString(): String {
            return this.name
        }
    }