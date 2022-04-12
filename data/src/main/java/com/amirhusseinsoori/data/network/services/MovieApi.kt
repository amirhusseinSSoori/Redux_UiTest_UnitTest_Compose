package com.amirhusseinsoori.data.network.services




import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.network.response.Movie
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun  getMovie(@Query("page") page: Int): List<Movie>

    @Headers("Content-Type: application/json")
    @GET("movie/{id}")
    suspend fun  getMovieById(@Path("id") id:Int) : Details
}