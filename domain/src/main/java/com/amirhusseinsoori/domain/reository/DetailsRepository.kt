package com.amirhusseinsoori.domain.reository

import com.amirhusseinsoori.domain.entity.DetailsEntity
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    fun getDetailsRepository(id:Int): Flow<Result<DetailsEntity>>
}