package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.domain.exception.CustomResult
import com.amirhusseinsoori.data.mapper.mapDetailsToDomain
import com.amirhusseinsoori.data.network.services.MovieApi
import com.amirhusseinsoori.domain.entity.DetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class DetailsRepository @Inject constructor(private val api: MovieApi)  {
    fun getDetailsRepository(id:Int): Flow<CustomResult<DetailsEntity>> = flow{
        emit(CustomResult.success(api.getMovieById(id).mapDetailsToDomain()))
    }.catch {ex->
        emit(CustomResult.failure(ex))
    }
}