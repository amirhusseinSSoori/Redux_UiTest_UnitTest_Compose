package com.amirhusseinsoori.data.network.response


import com.amirhusseinsoori.data.network.response.Genres
import com.google.gson.annotations.SerializedName


data class Movie(

    @SerializedName("vote_count")
    var voteCount: Int?,

    @SerializedName("id")
    var serverId: Int?,

    @SerializedName("video")
    var video: Boolean?,

    @SerializedName("vote_average")
    var voteAverage: Double?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("popularity")
    var popularity: Double?,

    @SerializedName("poster_path")
    var posterPath: String?,

    @SerializedName("original_language")
    var originalLanguage: String?,

    @SerializedName("original_title")
    var originalTitle: String?,

    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @SerializedName("adult")
    var adult: Boolean?,

    @SerializedName("overview")
    var overview: String?,

    @SerializedName("release_date")
    var releaseDate: String?,

    @SerializedName("genres")
    var genreIds: List<Genres>?,

    )


