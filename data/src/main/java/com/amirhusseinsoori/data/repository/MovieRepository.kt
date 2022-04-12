package com.amirhusseinsoori.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.data.network.pager.MoviePagingSource
import com.amirhusseinsoori.data.network.response.Movie
import com.amirhusseinsoori.data.network.services.MovieApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class MovieRepository @Inject constructor(
    private val api: MovieApi,
) {
    fun getAllIMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(api = api)
            }
        ).flow
    }
}