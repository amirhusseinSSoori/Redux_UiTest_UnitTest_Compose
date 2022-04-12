package com.amirhusseinsoori.code_challenge

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.code_challenge.model.Movie
import com.amirhusseinsoori.code_challenge.network.CustomPagingSource
import com.amirhusseinsoori.code_challenge.network.TmdbApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val api: TmdbApi,
) {

    fun getAllIMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                CustomPagingSource(api = api)
            }
        ).flow
    }



}