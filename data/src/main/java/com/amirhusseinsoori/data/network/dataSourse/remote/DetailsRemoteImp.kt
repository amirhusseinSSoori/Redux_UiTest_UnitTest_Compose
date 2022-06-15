package com.amirhusseinsoori.data.network.dataSourse.remote

import com.amirhusseinsoori.common.Constant.BaseUrl
import com.amirhusseinsoori.data.mapper.mapDetailsToDomain
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.entity.DetailsEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRemoteImp @Inject constructor(private val api: HttpClient) : DetailsRemote {
    override fun fetchDetailsRepository(id: Int): Flow<Result<DetailsEntity>> = flow {
        emit(Result.success(api.get {
            url("$BaseUrl${"movie/$id"}")
        }.body<Details>().mapDetailsToDomain()))
    }.catch { ex ->
        emit(Result.failure(ex))
    }.flowOn(Dispatchers.IO)
}
