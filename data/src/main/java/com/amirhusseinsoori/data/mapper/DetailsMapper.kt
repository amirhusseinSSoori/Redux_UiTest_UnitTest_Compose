package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.common.Constant.NoData
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.network.response.movieDetails.Genre
import com.amirhusseinsoori.data.network.response.movieDetails.ProductionCompany
import com.amirhusseinsoori.data.network.response.movieDetails.ProductionCountry
import com.amirhusseinsoori.data.network.response.movieDetails.SpokenLanguage
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.entity.details.GenreEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCompanyEntity
import com.amirhusseinsoori.domain.entity.details.ProductionCountryEntity
import com.amirhusseinsoori.domain.entity.details.SpokenLanguageEntity


fun Details.mapDetailsToDomain(): DetailsEntity {
    return DetailsEntity(
        adult = adult,
        backdrop_path = backdrop_path ?: NoData,
        belongs_to_collection = if (belongs_to_collection is String) belongs_to_collection else NoData,
        budget = budget,
        genres = genres?.mapGenreListToDomain(),
        homepage = homepage ?: NoData,
        id = id,
        imdb_id = imdb_id ?: NoData,
        original_language = original_language ?: NoData,
        original_title = original_title ?: NoData,
        overview = overview ?: NoData,
        popularity = popularity,
        poster_path = if (poster_path is String) poster_path else NoData,
        production_companies = production_companies?.mapListProductionCompanyToDomain(),
        production_countries = production_countries?.mapListProductionCountryToDomain(),
        release_date = release_date ?: NoData,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages?.mapListSpokenLanguageToDomain(),
        status = status ?: NoData,
        tagline = tagline ?: NoData,
        title = title ?: NoData,
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
        iso_639_1 = iso_639_1 ?: NoData,
        name = name ?: NoData
    )
}

fun ProductionCountry.mapProductionCountryToDomain(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso_3166_1 = iso_3166_1 ?: NoData,
        name = name ?: NoData
    )

}

fun List<ProductionCountry>.mapListProductionCountryToDomain(): List<ProductionCountryEntity> {
    return map { it.mapProductionCountryToDomain() }
}


fun ProductionCompany.mapProductionCompanyToDomain(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = id,
        logo_path = logo_path ?: NoData,
        name = name ?: NoData,
        origin_country = origin_country ?: NoData
    )
}

fun List<ProductionCompany>.mapListProductionCompanyToDomain(): List<ProductionCompanyEntity> {
    return map { it.mapProductionCompanyToDomain() }
}

fun Genre.mapGenreToDomain(): GenreEntity {
    return GenreEntity(
        id = id,
        name = name ?: NoData
    )
}

fun List<Genre>.mapGenreListToDomain(): List<GenreEntity> {
    return map { it.mapGenreToDomain() }
}