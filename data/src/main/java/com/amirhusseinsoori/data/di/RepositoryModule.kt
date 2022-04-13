package com.amirhusseinsoori.data.di

import androidx.paging.ExperimentalPagingApi
import com.amirhusseinsoori.data.repository.DetailsRepositoryImp
import com.amirhusseinsoori.data.repository.MovieRepositoryImp
import com.amirhusseinsoori.domain.reository.DetailsRepository
import com.amirhusseinsoori.domain.reository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @OptIn(ExperimentalPagingApi::class)
    @Binds
    abstract fun bindMovieRepository(movieRepositoryImp: MovieRepositoryImp): MovieRepository


    @Binds
    abstract fun bindDetailsRepository(detailsRepositoryImp: DetailsRepositoryImp): DetailsRepository
}