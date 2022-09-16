package com.amirhusseinsoori.data.mapper

import com.amirhusseinsoori.common.Constant.NoData
import com.amirhusseinsoori.data.network.response.Movie
import com.amirhusseinsoori.domain.entity.MovieEntity


fun Movie.mapMovieToDomain(): MovieEntity {
    return MovieEntity(
        adult = adult,
        backdrop_path = backdrop_path ?: NoData,
        genre_ids = genre_ids,
        id = id,
        original_language = original_language ?: NoData,
        original_title = original_title ?: NoData,
        overview = overview ?: NoData,
        popularity = popularity,
        poster_path = poster_path ?: NoData,
        release_date = release_date ?: NoData,
        title = title ?: NoData,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )

}


fun List<Movie>.mapListMovieToDomain(): List<MovieEntity> {
    return map { it.mapMovieToDomain() }
}