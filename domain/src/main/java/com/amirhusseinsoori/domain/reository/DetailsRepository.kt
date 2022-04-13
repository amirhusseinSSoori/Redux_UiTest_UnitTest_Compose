package com.amirhusseinsoori.domain.reository

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.exception.CustomResult
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    fun getDetailsRepository(id:Int): Flow<CustomResult<DetailsEntity>>
}