package com.amirhusseinsoori.domain.entity

import com.amirhusseinsoori.domain.entity.details.GenreEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCompanyEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCountryEntity
import com.amirhusseinsoori.domain.entity.details.SpokenLanguageEntity

data class DetailsEntity(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val belongs_to_collection: Any? = null,
    val budget: Int? = null,
    val genres: List<GenreEntity>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val imdb_id: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: Any? = null,
    val production_companies: List<ProductionCompanyEntity>? = null,
    val production_countries: List<ProductionCountryEntity>? = null,
    val release_date: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val spoken_languages: List<SpokenLanguageEntity>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)