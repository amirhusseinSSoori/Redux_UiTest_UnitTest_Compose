package com.amirhusseinsoori.domain.reository

import androidx.paging.PagingData
import com.amirhusseinsoori.domain.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllIMovies(): Flow<PagingData<MovieEntity>>
}