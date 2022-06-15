package com.amirhusseinsoori.data.network.response.movieDetails

import kotlinx.serialization.Serializable

@Serializable
data class SpokenLanguage(
    val iso_639_1: String?=null,
    val name: String?=null
)