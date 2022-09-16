package com.amirhusseinsoori.data.network.dataSourse.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.data.network.pager.MoviePagingSource
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import com.amirhusseinsoori.domain.entity.MovieEntity
import io.ktor.client.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRemoteImp @Inject constructor(private val api: HttpClient) : MovieRemote {
    override fun fetchAllIMovies(): Flow<PagingData<MovieEntity>> {
        return Pager(
            PagingConfig(
                pageSize = 50, maxSize = 500,
                enablePlaceholders = false
            )
        ) {
            MoviePagingSource(api = api)
        }.flow.flowOn(Dispatchers.IO)
    }
}
