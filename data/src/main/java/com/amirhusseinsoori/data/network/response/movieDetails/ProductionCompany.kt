package com.amirhusseinsoori.data.network.response.movieDetails

import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    val id: Int,
    val logo_path: String? = null,
    val name: String? = null,
    val origin_country: String? = null
)