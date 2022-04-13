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
        backdrop_path = backdrop_path,
        belongs_to_collection = belongs_to_collection,
        budget = budget,
        genres = genres?.mapGenreListToDomain(),
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_companies = production_companies?.mapListProductionCompanyToDomain(),
        production_countries = production_countries?.mapListProductionCountryToDomain(),
        release_date = release_date,
        revenue = revenue,
        runtime = runtime,
        spoken_languages = spoken_languages?.mapListSpokenLanguageToDomain(),
        status = status,
        tagline = tagline,
        title = title,
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
        iso_639_1 = iso_639_1,
        name = name
    )
}

fun ProductionCountry.mapProductionCountryToDomain(): ProductionCountryEntity {
    return ProductionCountryEntity(
        iso_3166_1 = iso_3166_1,
        name = name
    )

}

fun List<ProductionCountry>.mapListProductionCountryToDomain(): List<ProductionCountryEntity> {
    return map { it.mapProductionCountryToDomain() }
}


fun ProductionCompany.mapProductionCompanyToDomain(): ProductionCompanyEntity {
    return ProductionCompanyEntity(
        id = id,
        logo_path = logo_path,
        name = name,
        origin_country = origin_country
    )
}

fun List<ProductionCompany>.mapListProductionCompanyToDomain(): List<ProductionCompanyEntity> {
    return map { it.mapProductionCompanyToDomain() }
}

fun Genre.mapGenreToDomain(): GenreEntity {
    return GenreEntity(
        id = id,
        name = name
    )
}

fun List<Genre>.mapGenreListToDomain(): List<GenreEntity> {
    return map { it.mapGenreToDomain() }
}