package com.amirhusseinsoori.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.reository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class MovieRepositoryImp @Inject constructor(
    private val remote: MovieRemote,
) : MovieRepository {
    override fun getAllIMovies(): Flow<PagingData<MovieEntity>> {
        return remote.fetchAllIMovies()
    }
}