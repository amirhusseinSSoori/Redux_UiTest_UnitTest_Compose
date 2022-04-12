package com.amirhusseinsoori.code_challenge.model


import com.google.gson.annotations.SerializedName

data class Genres(

    @SerializedName("id")
    var serverId: Int?,

    @SerializedName("name")
    var name: String?
)