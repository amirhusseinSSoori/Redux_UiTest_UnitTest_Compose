package com.amirhusseinsoori.domain.useCase

import androidx.paging.PagingData
import com.amirhusseinsoori.domain.entity.MovieEntity
import com.amirhusseinsoori.domain.reository.MovieRepository
import com.amirhusseinsoori.domain.useCase.base.UseCaseImmediate
import kotlinx.coroutines.flow.Flow
import java.lang.NullPointerException
import javax.inject.Inject

class ListMovieUseCase @Inject constructor(private val repository: MovieRepository) :
    UseCaseImmediate<Flow<PagingData<MovieEntity>>>() {
    override fun buildUseCaseImmediate(): Flow<PagingData<MovieEntity>> {
        return repository.getAllIMovies()
    }
}