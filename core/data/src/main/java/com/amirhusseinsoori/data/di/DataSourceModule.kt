package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.network.dataSourse.remote.DetailsRemoteImp
import com.amirhusseinsoori.data.network.dataSourse.remote.MovieRemoteImp
import com.amirhusseinsoori.domain.dataSource.remote.DetailsRemote
import com.amirhusseinsoori.domain.dataSource.remote.MovieRemote
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {


    @Binds
    abstract fun bindMovieRemote(movieRemoteImp: MovieRemoteImp): MovieRemote


    @Binds
    abstract fun bindDetailsRemote(detailsRemoteImp: DetailsRemoteImp): DetailsRemote

}