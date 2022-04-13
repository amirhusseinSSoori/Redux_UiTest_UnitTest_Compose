package com.amirhusseinsoori.data.mapper

import androidx.lifecycle.Transformations.map
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.network.response.movieDetails.Genre
import com.amirhusseinsoori.data.network.response.movieDetails.ProductionCompany
import com.amirhusseinsoori.data.network.response.movieDetails.ProductionCountry
import com.amirhusseinsoori.data.network.response.movieDetails.SpokenLanguage
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.entity.GenresEntity
import com.amirhusseinsoori.domain.entity.details.GenreEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCompanyEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCountryEntity
import com.amirhusseinsoori.domain.entity.details.SpokenLanguageEntity


fun Details.mapDetailsToDomain(): DetailsEntity {
    return DetailsEntity(
        adult = adult,
        backdrop_path = backdrop_path ?: "no Data",
        belongs_to_collection = if (belongs_to_collection is String) belongs_to_collection else "no Data",
        budget = budget,
        genres = genres?.mapGenreListToDomain(),
        homepage = homepage ?: "no Data",
        id = id,
        imdb_id = imdb_id ?: "no Data",
        original_language = original_language ?: "no Data",
        original_title = original_title ?: "no Data",
        overview = overview ?: "no Data",
        popularity = popularity,
        poster_path = if (poster_path is String) poster_path else "no Data",
        production_companies = production_companies?.mapListProductionCompanyToDomain(),
        production_countries = production_countries?.mapListProductionCountryToDomain(),
        release_date = release_date ?: "no Data",
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages?.mapListSpokenLanguageToDomain(),
        status = status ?: "no Data",
        tagline = tagline ?: "no Data",
        title = title ?: "no Data",
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )

}

fun List<SpokenLanguage>.mapListSpokenLanguageToDomain(): List<SpokenLanguageEntity> {
    return map { it.mapSpokenLanguageToDomain() }
}

fun SpokenLanguage.mapSpokenLanguageToDomain(): SpokenLanguageEntity {
    return SpokenLanguageEntity(
        iso_639_1 = iso_639_1 ?: "no Data",
        name = name ?: "no Data"
    )
}

fun ProductionCountry.mapProductionCountryToDomain(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso_3166_1 = iso_3166_1 ?: "no Data",
        name = name ?: "no Data"
    )

}

fun List<ProductionCountry>.mapListProductionCountryToDomain(): List<ProductionCountryEntity> {
    return map { it.mapProductionCountryToDomain() }
}


fun ProductionCompany.mapProductionCompanyToDomain(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = id,
        logo_path = logo_path ?: "no Data",
        name = name ?: "no Data",
        origin_country = origin_country ?: "no Data"
    )
}

fun List<ProductionCompany>.mapListProductionCompanyToDomain(): List<ProductionCompanyEntity> {
    return map { it.mapProductionCompanyToDomain() }
}

fun Genre.mapGenreToDomain(): GenreEntity {
    return GenreEntity(
        id = id,
        name = name ?: "no Data"
    )
}

fun List<Genre>.mapGenreListToDomain(): List<GenreEntity> {
    return map { it.mapGenreToDomain() }
}