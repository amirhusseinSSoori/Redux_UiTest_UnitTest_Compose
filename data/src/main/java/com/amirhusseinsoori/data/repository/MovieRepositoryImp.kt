package com.amirhusseinsoori.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.amirhusseinsoori.data.network.pager.MoviePagingSource
import com.amirhusseinsoori.data.network.response.Movie
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.reository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalPagingApi
class MovieRepositoryImp @Inject constructor(
    private val api: MovieApi,
): MovieRepository {
    override fun getAllIMovies(): Flow<PagingData<MovieEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(api = api)
            }
        ).flow.flowOn(Dispatchers.IO)
    }
}