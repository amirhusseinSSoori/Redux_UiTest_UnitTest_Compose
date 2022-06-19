package com.amirhusseinsoori.common

import com.amirhusseinsoori.common.Constant.BaseUrl

sealed class Urls(val endPoint:String){
    object  Movies:Urls("${BaseUrl}${"movie/popular"}")
    data class MovieDetails(val id:Int):Urls("$BaseUrl${"movie/$id"}")
}
