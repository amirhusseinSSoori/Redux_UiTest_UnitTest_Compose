package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.exception.CustomResult
import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseWithParamsImmediate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailsUseCase @Inject constructor(var repository: DetailsRepository):UseCaseWithParamsImmediate<Int, Flow<CustomResult<DetailsEntity>>>(){
    override suspend fun buildUseCaseImmediate(params: Int): Flow<CustomResult<DetailsEntity>> {
        return repository.getDetailsRepository(params)
    }
}