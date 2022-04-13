package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.data.network.response.Movie
import com.amirhusseinsoori.domain.entity.MovieEntity


fun Movie.mapMovieToDomain(): MovieEntity {
    return MovieEntity(
        adult = adult,
        backdrop_path = backdrop_path ?: "no Data",
        genre_ids = genre_ids,
        id = id,
        original_language = original_language ?: "no Data",
        original_title = original_title ?: "no Data",
        overview = overview ?: "no Data",
        popularity = popularity,
        poster_path = poster_path ?: "no Data",
        release_date = release_date ?: "no Data",
        title = title ?: "no Data",
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )

}


fun List<Movie>.mapListMovieToDomain(): List<MovieEntity> {
    return map { it.mapMovieToDomain() }
}