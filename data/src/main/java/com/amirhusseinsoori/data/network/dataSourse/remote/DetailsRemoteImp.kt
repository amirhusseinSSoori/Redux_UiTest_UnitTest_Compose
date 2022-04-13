package com.amirhusseinsoori.data.network.dataSourse.remote

import com.amirhusseinsoori.data.mapper.mapDetailsToDomain
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.entity.DetailsEntity
import com.amirhusseinsoori.domain.exception.CustomResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRemoteImp @Inject constructor(private val api: MovieApi):DetailsRemote{
    override fun fetchDetailsRepository(id: Int): Flow<CustomResult<DetailsEntity>> = flow {
        emit(CustomResult.success(api.getMovieById(id).mapDetailsToDomain()))
    }.catch { ex ->
        emit(CustomResult.failure(ex))
    }.flowOn(Dispatchers.IO)
}
