package com.amirhusseinsoori.data.network.dataSourse.remote

import com.amirhusseinsoori.common.Constant.BaseUrl
import com.amirhusseinsoori.common.Constant.apiKey
import com.amirhusseinsoori.data.di.withJsonFormat
import com.amirhusseinsoori.data.mapper.mapDetailsToDomain
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.entity.DetailsEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import javax.inject.Inject

class DetailsRemoteImp @Inject constructor(private val api: HttpClient) : DetailsRemote {

    override fun fetchDetailsRepository(id: Int): Flow<Result<DetailsEntity>> = flow {
        emit(Result.success(api.get {
            contentType(ContentType.Application.Json)
            parameter("api_key", apiKey)
            url("$BaseUrl/${"movie/$id"}")
        }.body<Details>().mapDetailsToDomain()))
    }.catch { ex ->
        emit(Result.failure(ex))
    }.flowOn(Dispatchers.IO)
}
