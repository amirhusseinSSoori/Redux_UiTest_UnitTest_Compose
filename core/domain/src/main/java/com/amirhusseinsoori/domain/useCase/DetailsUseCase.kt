package com.amirhusseinsoori.domain.useCase

import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseWithParamsImmediate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailsUseCase @Inject constructor(var repository: DetailsRepository) :
    UseCaseWithParamsImmediate<Int, Flow<Result<DetailsEntity>>>() {
    override suspend fun buildUseCaseImmediate(params: Int): Flow<Result<DetailsEntity>> {
        return repository.getDetailsRepository(params)
    }
}