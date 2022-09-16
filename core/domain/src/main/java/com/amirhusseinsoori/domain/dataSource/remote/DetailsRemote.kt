package com.amirhusseinsoori.domain.dataSource.remote

import com.amirhusseinsoori.domain.entity.DetailsEntity
import kotlinx.coroutines.flow.Flow

interface DetailsRemote {
    fun fetchDetailsRepository(id: Int): Flow<Result<DetailsEntity>>
}