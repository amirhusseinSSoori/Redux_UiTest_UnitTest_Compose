package com.amirhusseinsoori.data.network.dataSourse.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.data.network.pager.MoviePagingSource
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import com.amirhusseinsoori.domain.entity.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRemoteImp @Inject constructor(private val api: MovieApi) : MovieRemote {
    override fun fetchAllIMovies(): Flow<PagingData<MovieEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(api = api)
            }
        ).flow.flowOn(Dispatchers.IO)
    }
}