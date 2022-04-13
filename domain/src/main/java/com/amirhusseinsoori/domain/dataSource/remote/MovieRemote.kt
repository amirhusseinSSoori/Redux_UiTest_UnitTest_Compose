package com.amirhusseinsoori.domain.dataSource.remote

import androidx.paging.PagingData
import com.amirhusseinsoori.domain.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRemote {
    fun fetchAllIMovies(): Flow<PagingData<MovieEntity>>
}