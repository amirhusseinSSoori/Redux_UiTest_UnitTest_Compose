package com.amirhusseinsoori.domain.dataSource.remote

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.exception.CustomResult
import kotlinx.coroutines.flow.Flow

interface DetailsRemote {
    fun fetchDetailsRepository(id: Int): Flow<CustomResult<DetailsEntity>>
}