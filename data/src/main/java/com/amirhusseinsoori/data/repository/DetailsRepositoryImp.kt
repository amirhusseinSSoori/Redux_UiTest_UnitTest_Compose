package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.reository.DetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailsRepositoryImp @Inject constructor(private val remote: DetailsRemote) :
    DetailsRepository {
    override fun getDetailsRepository(id: Int): Flow<Result<DetailsEntity>> {
        return remote.fetchDetailsRepository(id)
    }
}