package com.amirhusseinsoori.data.repository

import com.amirhusseinsoori.data.exception.CustomResult
import com.amirhusseinsoori.data.network.response.Details
import com.amirhusseinsoori.data.network.services.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class DetailsRepository @Inject constructor(private val api: MovieApi)  {
    fun getDetailsRepository(): Flow<CustomResult<Details>> = flow{
        emit(CustomResult.success(api.getMovieById(675353)))
    }.catch {ex->
        emit(CustomResult.failure(ex))
    }
}